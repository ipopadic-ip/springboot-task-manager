package com.ilija.service;


import org.springframework.stereotype.Service;

import com.ilija.dto.ZadatakDTO;
import com.ilija.model.Zadatak;
import com.ilija.repository.ZadatakRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ZadatakService {
	 private final ZadatakRepository zadatakRepository;

	    public ZadatakService(ZadatakRepository zadatakRepository) {
	        this.zadatakRepository = zadatakRepository;
	    }

	    public List<Zadatak> getAllZadaci() {
	        return zadatakRepository.findAll();
	    }

	    public Optional<Zadatak> getZadatakById(Long id) {
	        return zadatakRepository.findById(id);
	    }

	    public Zadatak createZadatak(ZadatakDTO zadatakDTO) {
	        Zadatak zadatak = new Zadatak();
	        zadatak.setNaziv(zadatakDTO.getNaziv());
	        zadatak.setOpis(zadatakDTO.getOpis());
	        zadatak.setRok(zadatakDTO.getRok());
	        zadatak.setPrioritet(zadatakDTO.getPrioritet());
//	        zadatak.setStatus(zadatakDTO.getStatus());
	        return zadatakRepository.save(zadatak);
	    }

	    public Zadatak updateZadatak(Long id, ZadatakDTO zadatakDTO) {
	        return zadatakRepository.findById(id).map(zadatak -> {
	        	 	zadatak.setNaziv(zadatakDTO.getNaziv());
	 	        	zadatak.setOpis(zadatakDTO.getOpis());
		 	        zadatak.setRok(zadatakDTO.getRok());
		 	        zadatak.setPrioritet(zadatakDTO.getPrioritet());
//		 	        zadatak.setStatus(zadatakDTO.getStatus());
	            return zadatakRepository.save(zadatak);
	        }).orElseThrow(() -> new RuntimeException("Zadatak not found"));
	    }

	    public void deleteZadatak(Long id) {
	    	zadatakRepository.deleteById(id);
	    }

}
