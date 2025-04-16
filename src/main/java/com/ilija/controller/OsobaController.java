package com.ilija.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ilija.dto.OsobaDTO;
import com.ilija.model.Osoba;
import com.ilija.service.OsobaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/osobe")
public class OsobaController {
	 private final OsobaService osobaService;

	    public OsobaController(OsobaService osobaService) {
	        this.osobaService = osobaService;
	    }

	    @GetMapping
	    public List<Osoba> getAllOsobe() {
	        return osobaService.getAllOsobe();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Osoba> getOsobaById(@PathVariable Long id) {
	        Optional<Osoba> osoba = osobaService.getOsobaById(id);
	        return osoba.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Osoba createOsoba(@RequestBody OsobaDTO osobaDTO) {
	        return osobaService.createOsoba(osobaDTO);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Osoba> updateOsoba(@PathVariable Long id, @RequestBody OsobaDTO osobaDTO) {
	        try {
	            return ResponseEntity.ok(osobaService.updateOsoba(id, osobaDTO));
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOsoba(@PathVariable Long id) {
	        osobaService.deleteOsoba(id);
	        return ResponseEntity.noContent().build();
	    }
}
