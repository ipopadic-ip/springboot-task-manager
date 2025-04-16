package com.ilija.service;


import org.springframework.stereotype.Service;

import com.ilija.dto.OsobaDTO;
import com.ilija.model.Osoba;
import com.ilija.repository.OsobaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OsobaService {
	 private final OsobaRepository osobaRepository;

	    public OsobaService(OsobaRepository osobaRepository) {
	        this.osobaRepository = osobaRepository;
	    }

	    public List<Osoba> getAllOsobe() {
	        return osobaRepository.findAll();
	    }

	    public Optional<Osoba> getOsobaById(Long id) {
	        return osobaRepository.findById(id);
	    }

	    public Osoba createOsoba(OsobaDTO osobaDTO) {
	        Osoba osoba = new Osoba();
	        osoba.setIme(osobaDTO.getIme());
	        osoba.setPrezime(osobaDTO.getPrezime());
	        osoba.setEmail(osobaDTO.getEmail());
	        return osobaRepository.save(osoba);
	    }

	    public Osoba updateOsoba(Long id, OsobaDTO osobaDTO) {
	        return osobaRepository.findById(id).map(osoba -> {
	            osoba.setIme(osobaDTO.getIme());
	            osoba.setPrezime(osobaDTO.getPrezime());
	            osoba.setEmail(osobaDTO.getEmail());
	            return osobaRepository.save(osoba);
	        }).orElseThrow(() -> new RuntimeException("Osoba not found"));
	    }

	    public void deleteOsoba(Long id) {
	        osobaRepository.deleteById(id);
	    }
}