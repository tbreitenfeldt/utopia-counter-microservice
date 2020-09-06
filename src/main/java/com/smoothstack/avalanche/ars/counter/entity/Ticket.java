package com.smoothstack.avalanche.ars.counter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ticket")
public class Ticket {

	/*
	 * FIELDS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "seat_number")
	private String seat_number;

	/*
	 * ENTITY RELATIONSHIPS
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_number")
	private Flight flight;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itinerary_id")
	@JsonManagedReference
	@JsonIgnore
	private Itinerary itinerary;
	
	@OneToOne(mappedBy = "ticket")
	@JsonIgnore
	private BoardingPass boarding_pass;
	
	/*
	 * CONSTRUCTORS
	 */
	public Ticket() {}
	/**
	 * @param id
	 * @param flight_number
	 * @param itinerary_id
	 * @param status
	 * @param seat_number
	 */
	public Ticket(Long id, String status, String seat_number) {
		this.id = id;
		this.status = status;
		this.seat_number = seat_number;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the seat_number
	 */
	public String getSeat_number() {
		return seat_number;
	}
	
	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}
	/**
	 * @return the boarding_pass
	 */
	public BoardingPass getBoarding_pass() {
		return boarding_pass;
	}

	/**
	 * @return the itinerary
	 */

	public Itinerary getItinerary() {
		return itinerary;
	}
	/*
	 * SETTERS
	 */
	/**
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param seat_number the seat_number to set
	 */
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	/**
	 * @param boarding_pass the boarding_pass to set
	 */
	public void setBoarding_pass(BoardingPass boarding_pass) {
		this.boarding_pass = boarding_pass;
	}
	
	/*
	 * OVERRIDE OBJECT METHOD
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((seat_number == null) ? 0 : seat_number.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (seat_number == null) {
			if (other.seat_number != null)
				return false;
		} else if (!seat_number.equals(other.seat_number))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}
