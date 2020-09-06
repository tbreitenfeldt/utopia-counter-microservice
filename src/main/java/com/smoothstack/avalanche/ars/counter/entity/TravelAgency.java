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
@Table(name = "travel_agency")
public class TravelAgency {

	/*
	 * FIELDS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;
	
	@Column(name = "commission_rate")
	private double commission_rate;

	/*
	 * ENTITY RELATIONSHIP
	 */
	@OneToMany(mappedBy = "agency",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnore
	private List<User> agents;
	
	@OneToMany(mappedBy = "agency",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonIgnore
	private List<Itinerary> itineraries;
	
	/*
	 * CONSTRUCTOR
	 */
	public TravelAgency() {}
	/**
	 * @param id
	 * @param name
	 * @param phone
	 * @param email
	 * @param commission_rate
	 */
	public TravelAgency(Long id, String name, String phone, String email, double commission_rate) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.commission_rate = commission_rate;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the commission_rate
	 */
	public double getCommission_rate() {
		return commission_rate;
	}
	/*
	 * SETTERS
	 */
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
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param commission_rate the commission_rate to set
	 */
	public void setCommission_rate(double commission_rate) {
		this.commission_rate = commission_rate;
	}
	/**
	 * @param agents the agents to set
	 */
	public void setAgents(List<User> agents) {
		this.agents = agents;
	}
	/**
	 * @param itineraries the itineraries to set
	 */
	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}
	/*
	 * 	OVERRIDE METHOD OBJECT
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(commission_rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		TravelAgency other = (TravelAgency) obj;
		if (Double.doubleToLongBits(commission_rate) != Double.doubleToLongBits(other.commission_rate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	
}
