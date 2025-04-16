package com.ilija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ilija.model.AngazovanaOsoba;

@Repository
public interface AngazovanaOsobaRepository extends JpaRepository<AngazovanaOsoba, Long> {
}