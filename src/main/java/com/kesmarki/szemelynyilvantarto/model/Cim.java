package com.kesmarki.szemelynyilvantarto.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cimek")
public class Cim {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne 
    private Szemely szemely;
    
    @OneToMany(mappedBy="cim")
    private Set<Elerhetoseg> elerhetosegek;
    
	@Column(name = "country")
    private String country;
    
	@Column(name = "city")
    private String city;
    
	@Column(name = "street")
    private String street;
    
	@Column(name = "building_number")
    private int buildingNumber;
    	
    public Cim(Szemely szemely) {
		this.szemely = szemely;
	}
    
    public Cim() {		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Szemely getSzemely() {
		return szemely;
	}

	public void setSzemely(Szemely szemely) {
		this.szemely = szemely;
	}

	public Set<Elerhetoseg> getElerhetosegek() {
		return elerhetosegek;
	}

	public void setElerhetosegek(Set<Elerhetoseg> elerhetosegek) {
		this.elerhetosegek = elerhetosegek;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

}
