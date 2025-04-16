package com.ilija.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class AngazovanaOsoba {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private LocalDate pocetak;
	private LocalDate kraj;
    
    @ManyToOne
    @JoinColumn(name = "osoba_id", nullable = false)
    private Osoba osoba;
    
    @ManyToOne
    @JoinColumn(name = "zadatak_id", nullable = false)
    private Zadatak zadatak;

    public AngazovanaOsoba() {}

	public AngazovanaOsoba(Long id, LocalDate pocetak, LocalDate kraj, Osoba osoba, Zadatak zadatak) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.osoba = osoba;
		this.zadatak = zadatak;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public Zadatak getZadatak() {
		return zadatak;
	}

	public void setZadatak(Zadatak zadatak) {
		this.zadatak = zadatak;
	}
    
}
