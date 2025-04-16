package com.ilija.model;
import java.util.List;


import jakarta.persistence.*;

@Entity
public class Osoba {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String ime;
    private String prezime;
    private String email;
    
    @OneToMany(mappedBy = "osoba", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AngazovanaOsoba> angazovaneOsobe;
    
    

	public Osoba() {
		super();
	}

	public Osoba(Long id, String ime, String prezime, String email, List<AngazovanaOsoba> angazovaneOsobe) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.angazovaneOsobe = angazovaneOsobe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AngazovanaOsoba> getAngazovaneOsobe() {
		return angazovaneOsobe;
	}

	public void setAngazovaneOsobe(List<AngazovanaOsoba> angazovaneOsobe) {
		this.angazovaneOsobe = angazovaneOsobe;
	}
    
    

}
