package com.ilija.dto;

import java.time.LocalDate;

public class AngazovanaOsobaDTO {
	private Long id;
	private LocalDate pocetak;
	private LocalDate kraj;
    private Long osobaId;
    private Long zadatakId;
    
    

    public AngazovanaOsobaDTO(Long id, LocalDate pocetak, LocalDate kraj, Long osobaId, Long zadatakId) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.osobaId = osobaId;
		this.zadatakId = zadatakId;
	}

	public AngazovanaOsobaDTO() {}

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

	public Long getOsobaId() {
		return osobaId;
	}

	public void setOsobaId(Long osobaId) {
		this.osobaId = osobaId;
	}

	public Long getZadatakId() {
		return zadatakId;
	}

	public void setZadatakId(Long zadatakId) {
		this.zadatakId = zadatakId;
	}
    
}
