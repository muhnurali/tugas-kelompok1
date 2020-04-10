package com.lawencon.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CovidCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCase;
	
	@Column(nullable = false, unique = true)
	private String kota;
	
	@Column(nullable = true)
	private int positif, meninggal, sembuh, pdp, odp;

	public Integer getIdCase() {
		return idCase;
	}

	public void setIdCase(Integer idCase) {
		this.idCase = idCase;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public int getPositif() {
		return positif;
	}

	public void setPositif(int positif) {
		this.positif = positif;
	}

	public int getMeninggal() {
		return meninggal;
	}

	public void setMeninggal(int meninggal) {
		this.meninggal = meninggal;
	}

	public int getSembuh() {
		return sembuh;
	}

	public void setSembuh(int sembuh) {
		this.sembuh = sembuh;
	}

	public int getPdp() {
		return pdp;
	}

	public void setPdp(int pdp) {
		this.pdp = pdp;
	}

	public int getOdp() {
		return odp;
	}

	public void setOdp(int odp) {
		this.odp = odp;
	}
}
