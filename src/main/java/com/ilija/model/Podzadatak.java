package com.ilija.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Podzadatak {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String naziv;
	    private String opis;
	    private double status;
	    private LocalDate rok;

	    @ManyToOne
	    @JoinColumn(name = "zadatak_id")
	    private Zadatak zadatak;

	    public Podzadatak() {}

	    public Podzadatak(String naziv, String opis, double status, LocalDate rok, Zadatak zadatak) {
	        this.naziv = naziv;
	        this.opis = opis;
	        this.status = status;
	        this.rok = rok;
	        this.zadatak = zadatak;
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

		public double getStatus() {
			return status;
		}

		public void setStatus(double status) {
			this.status = status;
		}

		public LocalDate getRok() {
			return rok;
		}

		public void setRok(LocalDate rok) {
			this.rok = rok;
		}

		public Zadatak getZadatak() {
			return zadatak;
		}

		public void setZadatak(Zadatak zadatak) {
			this.zadatak = zadatak;
		}
	    
}
