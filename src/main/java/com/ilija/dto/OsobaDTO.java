package com.ilija.dto;

public class OsobaDTO {
	private String ime;
    private String prezime;
    private String email;
	public OsobaDTO(String ime, String prezime, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
	}
	public OsobaDTO() {
		super();
		// TODO Auto-generated constructor stub
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
    
}
