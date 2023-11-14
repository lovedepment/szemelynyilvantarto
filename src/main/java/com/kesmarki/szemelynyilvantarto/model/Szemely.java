package com.kesmarki.szemelynyilvantarto.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "szemelyek")
public class Szemely {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "permanent_address")
	private Cim permanentAddress;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "residential_address")
	private Cim residentialAddress;

	public Szemely() {
	}

	public Szemely(String firstName, String lastName, Cim permanentAddress, Cim residentialAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.permanentAddress = permanentAddress;
		this.residentialAddress = residentialAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Cim getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Cim permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Cim getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(Cim residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

}
