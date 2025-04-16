package com.ilija.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ilija.dto.ZadatakDTO;
import com.ilija.model.Zadatak;
import com.ilija.service.ZadatakService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zadaci")
public class ZadatakController {
	 private final ZadatakService zadatakService;

	    public ZadatakController(ZadatakService zadatakService) {
	        this.zadatakService = zadatakService;
	    }

	    @GetMapping
	    public List<Zadatak> getAllZadaci() {
	        return zadatakService.getAllZadaci();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Zadatak> getZadatakById(@PathVariable Long id) {
	        Optional<Zadatak> zadatak = zadatakService.getZadatakById(id);
	        return zadatak.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Zadatak createZadatak(@RequestBody ZadatakDTO zadatakDTO) {
	        return zadatakService.createZadatak(zadatakDTO);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Zadatak> updateZadatak(@PathVariable Long id, @RequestBody ZadatakDTO zadatakDTO) {
	        try {
	            return ResponseEntity.ok(zadatakService.updateZadatak(id, zadatakDTO));
	        } catch (RuntimeException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteZadatak(@PathVariable Long id) {
	        zadatakService.deleteZadatak(id);
	        return ResponseEntity.noContent().build();
	    }
}
