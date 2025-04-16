package com.ilija.model;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.*;

@Entity
public class Zadatak {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String naziv;
    private String opis;
    private LocalDate rok;
    private Long prioritet;
//    private double status;
    @OneToMany(mappedBy = "zadatak", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Podzadatak> podzadaci;
    
    @OneToMany(mappedBy = "zadatak", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AngazovanaOsoba> angazovaneOsobe;

    
    
	public Zadatak() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zadatak(Long id, String naziv, String opis, LocalDate rok, Long prioritet,
			List<AngazovanaOsoba> angazovaneOsobe) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.rok = rok;
		this.prioritet = prioritet;
//		this.status = status;
		this.angazovaneOsobe = angazovaneOsobe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public LocalDate getRok() {
		return rok;
	}

	public void setRok(LocalDate rok) {
		this.rok = rok;
	}

	public Long getPrioritet() {
		return prioritet;
	}

	public void setPrioritet(Long prioritet) {
		this.prioritet = prioritet;
	}

//	public double getStatus() {
//		return status;
//	}
//
//	public void setStatus(double status) {
//		this.status = status;
//	}

	public List<AngazovanaOsoba> getAngazovaneOsobe() {
		return angazovaneOsobe;
	}

	public void setAngazovaneOsobe(List<AngazovanaOsoba> angazovaneOsobe) {
		this.angazovaneOsobe = angazovaneOsobe;
	}
	
	 public List<Podzadatak> getPodzadaci() { 
		 return podzadaci;
	 }
	 public void setPodzadaci(List<Podzadatak> podzadaci) { 
		 this.podzadaci = podzadaci; 
	 }

	 public double getStatus() {
	        if (podzadaci == null || podzadaci.isEmpty()) {
	            return 0.0;
	        }
	        return podzadaci.stream().mapToDouble(Podzadatak::getStatus).average().orElse(0.0);
	    }
    
    

}
