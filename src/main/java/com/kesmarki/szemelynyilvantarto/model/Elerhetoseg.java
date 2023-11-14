package com.kesmarki.szemelynyilvantarto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "elerhetoseg")
public class Elerhetoseg {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "cim_id", nullable = false)
	private Cim cim;

	@Enumerated(EnumType.STRING)
	private ElerhetosegType elerhetosegType;

	@Column(name = "elerhetoseg")
	private String elerhetoseg;

	public Elerhetoseg(Cim cim, ElerhetosegType elerhetosegType, String elerhetoseg) {
		this.cim = cim;
		this.elerhetosegType = elerhetosegType;
		this.elerhetoseg = elerhetoseg;
	}

	public Elerhetoseg() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cim getCim() {
		return cim;
	}

	public void setCim(Cim cim) {
		this.cim = cim;
	}

	public ElerhetosegType getElerhetosegType() {
		return elerhetosegType;
	}

	public void setElerhetosegType(ElerhetosegType elerhetosegType) {
		this.elerhetosegType = elerhetosegType;
	}

	public String getElerhetoseg() {
		return elerhetoseg;
	}

	public void setElerhetoseg(String elerhetoseg) {
		this.elerhetoseg = elerhetoseg;
	}

}
