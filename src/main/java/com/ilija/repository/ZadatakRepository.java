package com.ilija.repository;

import com.ilija.model.Zadatak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {
}