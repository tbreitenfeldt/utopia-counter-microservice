package com.smoothstack.avalanche.ars.counter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "airport")
public class Airport {

	/*
	 * FIELDS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private String postal_code;
	
	/*
	 * ENTITY RELATIONSHIP
	 */
	@OneToMany(mappedBy = "dest_airport",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnore
	private List<Flight> destFlights;
	
	@OneToMany(mappedBy = "origin_airport",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnore
	private List<Flight> originFlights;
	
	/*
	 * CONSTRUCTORS
	 */
	public Airport() {}
	
	/**
	 * @param id
	 * @param name
	 * @param street
	 * @param country
	 * @param state
	 * @param city
	 * @param postal_cude
	 */
	public Airport(Long id, String name, String street, String country, String state, String city, String postal_code) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.country = country;
		this.state = state;
		this.city = city;
		this.postal_code = postal_code;
	}

	/*
	 * GETTERS
	 */
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the postal_cude
	 */
	public String getPostal_code() {
		return postal_code;
	}
	
	/**
	 * @return the destFlights
	 */
	public List<Flight> getDestFlights() {
		return destFlights;
	}

	/**
	 * @return the originFlights
	 */
	public List<Flight> getOriginFlights() {
		return originFlights;
	}

	/*
	 * SETTERS
	 */
	/**
	 * @param destFlights the destFlights to set
	 */
	public void setDestFlights(List<Flight> destFlights) {
		this.destFlights = destFlights;
	}

	/**
	 * @param originFlights the originFlights to set
	 */
	public void setOriginFlights(List<Flight> originFlights) {
		this.originFlights = originFlights;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param postal_cude the postal_cude to set
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

 
	
	/*
	 * OVERRIDE METHOD OBJECTS
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postal_code == null) ? 0 : postal_code.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postal_code == null) {
			if (other.postal_code != null)
				return false;
		} else if (!postal_code.equals(other.postal_code))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
				return false;
		return true;
	}
	
}
