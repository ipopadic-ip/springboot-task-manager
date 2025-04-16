package com.ilija.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.ilija.dto.AngazovanaOsobaDTO;
import com.ilija.model.AngazovanaOsoba;
import com.ilija.model.Osoba;
import com.ilija.model.Zadatak;
import com.ilija.repository.AngazovanaOsobaRepository;
import com.ilija.repository.OsobaRepository;
import com.ilija.repository.ZadatakRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AngazovanaOsobaService {
	private final AngazovanaOsobaRepository angazovanaOsobaRepository;
    private final OsobaRepository osobaRepository;
    private final ZadatakRepository zadatakRepository;

    @Autowired
    public AngazovanaOsobaService(AngazovanaOsobaRepository angazovanaOsobaRepository, OsobaRepository osobaRepository, ZadatakRepository zadatakRepository) {
        this.angazovanaOsobaRepository = angazovanaOsobaRepository;
        this.osobaRepository = osobaRepository;
        this.zadatakRepository = zadatakRepository;
    }

    private AngazovanaOsobaDTO convertToDTO(AngazovanaOsoba entity) {
        return new AngazovanaOsobaDTO(entity.getId(), entity.getPocetak(), entity.getKraj(), entity.getOsoba().getId(), entity.getZadatak().getId());
    }

    public List<AngazovanaOsobaDTO> getAllAngazovaneOsobe() {
        return angazovanaOsobaRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    public Optional<AngazovanaOsobaDTO> getAngazovanaOsobaById(Long id) {
        return angazovanaOsobaRepository.findById(id).map(this::convertToDTO);
    }

    public AngazovanaOsobaDTO createAngazovanaOsoba(AngazovanaOsobaDTO dto) {
        Osoba osoba = osobaRepository.findById(dto.getOsobaId()).orElseThrow(() -> new RuntimeException("Osoba not found"));
        Zadatak zadatak = zadatakRepository.findById(dto.getZadatakId()).orElseThrow(() -> new RuntimeException("Zadatak not found"));

        if (dto.getPocetak().isAfter(dto.getKraj())) {
            throw new IllegalArgumentException("Datum početka ne može biti nakon datuma kraja.");
        }

        if (zadatak.getRok().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Zadatak sa rokom u prošlosti ne može biti definisan.");
        }

        AngazovanaOsoba entity = new AngazovanaOsoba();
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        entity.setOsoba(osoba);
        entity.setZadatak(zadatak);

        return convertToDTO(angazovanaOsobaRepository.save(entity));
    }

    public AngazovanaOsobaDTO updateAngazovanaOsoba(Long id, AngazovanaOsobaDTO dto) {
        return angazovanaOsobaRepository.findById(id).map(entity -> {
            Osoba osoba = osobaRepository.findById(dto.getOsobaId()).orElseThrow(() -> new RuntimeException("Osoba not found"));
            Zadatak zadatak = zadatakRepository.findById(dto.getZadatakId()).orElseThrow(() -> new RuntimeException("Zadatak not found"));

            if (dto.getPocetak().isAfter(dto.getKraj())) {
                throw new IllegalArgumentException("Datum početka ne može biti nakon datuma kraja.");
            }

            if (zadatak.getRok().isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Zadatak sa rokom u prošlosti ne može biti definisan.");
            }

            entity.setPocetak(dto.getPocetak());
            entity.setKraj(dto.getKraj());
            entity.setOsoba(osoba);
            entity.setZadatak(zadatak);

            return convertToDTO(angazovanaOsobaRepository.save(entity));
        }).orElseThrow(() -> new RuntimeException("AngazovanaOsoba not found"));
    }

    public void deleteAngazovanaOsoba(Long id) {
        angazovanaOsobaRepository.deleteById(id);
    }
    
    public List<AngazovanaOsobaDTO> getAngazovanjaURasponu(LocalDate pocetniDatum, LocalDate krajnjiDatum) {
        return angazovanaOsobaRepository.findAll()
                .stream()
                .filter(a -> (a.getPocetak().isAfter(pocetniDatum) || a.getPocetak().isEqual(pocetniDatum)) &&
                        (a.getKraj().isBefore(krajnjiDatum) || a.getKraj().isEqual(krajnjiDatum)))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<AngazovanaOsobaDTO> getRealizovanaAngazovanja() {
        return angazovanaOsobaRepository.findAll()
                .stream()
                .filter(a -> a.getKraj().isBefore(LocalDate.now()))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
