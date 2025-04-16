package com.ilija.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.ilija.dto.AngazovanaOsobaDTO;
import com.ilija.service.AngazovanaOsobaService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/angazovane-osobe")
public class AngazovanaOsobaController {
	 private final AngazovanaOsobaService service;

	    @Autowired
	    public AngazovanaOsobaController(AngazovanaOsobaService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<AngazovanaOsobaDTO> getAll() {
	        return service.getAllAngazovaneOsobe();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getById(@PathVariable Long id) {
	        return service.getAngazovanaOsobaById(id)
	                .map(ResponseEntity::ok)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pregled not found"));
	    }

	    @PostMapping
	    public ResponseEntity<?> create(@RequestBody AngazovanaOsobaDTO dto) {
	        try {
	            return ResponseEntity.ok(Map.of("message", "Angazovana osoba successfully created", "angazovanaOsoba", service.createAngazovanaOsoba(dto)));
	        } catch (RuntimeException e) {
	            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AngazovanaOsobaDTO dto) {
	        try {
	            return ResponseEntity.ok(Map.of("message", "Angazovana osoba successfully updated", "angazovanaOsoba", service.updateAngazovanaOsoba(id, dto)));
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
	        service.deleteAngazovanaOsoba(id);
	        return ResponseEntity.ok(Map.of("message", "Angazovana osoba successfully deleted"));
	    }
	    
	    @GetMapping("/raspon")
	    public List<AngazovanaOsobaDTO> getAngazovanjaURasponu(@RequestParam LocalDate pocetniDatum, @RequestParam LocalDate krajnjiDatum) {
	        return service.getAngazovanjaURasponu(pocetniDatum, krajnjiDatum);
	    }

	    @GetMapping("/realizovana")
	    public List<AngazovanaOsobaDTO> getRealizovanaAngazovanja() {
	        return service.getRealizovanaAngazovanja();
	    }
}
