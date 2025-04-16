package com.ilija.dto;

import java.time.LocalDate;

public class ZadatakDTO {
	private String naziv;
    private String opis;
    private LocalDate rok;
    private Long prioritet;
    private double status;
    
    
    
	public ZadatakDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZadatakDTO(String naziv, String opis, LocalDate rok, Long prioritet, double status) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.rok = rok;
		this.prioritet = prioritet;
		this.status = status;
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
	public double getStatus() {
		return status;
	}
	public void setStatus(double status) {
		this.status = status;
	}
    
    
}
