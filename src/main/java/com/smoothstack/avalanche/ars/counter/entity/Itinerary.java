package com.smoothstack.avalanche.ars.counter.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "itinerary")
public class Itinerary {

	/*
	 * FIELDS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "price_total")
	private double price_total;
	
	@Column(name = "date_created")
	private LocalDate date_created;

	/*
	 * ENTITY RELATIONSHIPS
	 */
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "agency_id")
	private TravelAgency agency;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "traveler_id")
	private Traveler traveler;
	
	@OneToMany(mappedBy = "itinerary",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JsonBackReference
	private List<Ticket> tickets;
	
	/*
	 * CONSTRUCTOR
	 */
	public Itinerary() {}
	
	public Itinerary(LocalDate date_created, 
			TravelAgency agency, 
			User user, 
			Traveler traveler) {
		this.date_created = date_created;
		this.agency = agency;
		this.user = user;
		this.traveler = traveler;
	}
	/**
	 * @param id
	 * @param price_total
	 * @param date_created
	 * @param agency
	 * @param user
	 * @param traveler
	 * @param tickets
	 */
	public Itinerary(Long id, double price_total, LocalDate date_created, TravelAgency agency, User user, Traveler traveler,
			List<Ticket> tickets) {
		super();
		this.id = id;
		this.price_total = price_total;
		this.date_created = date_created;
		this.agency = agency;
		this.user = user;
		this.traveler = traveler;
		this.tickets = tickets;
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
	 * @return the price_total
	 */
	public double getPrice_total() {
		return price_total;
	}
	/**
	 * @return the date_created
	 */
	public LocalDate getDate_created() {
		return date_created;
	}
	
	/**
	 * @return the agency
	 */
	public TravelAgency getAgency() {
		return agency;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the traveler
	 */
	public Traveler getTraveler() {
		return traveler;
	}
	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
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
	 * @param price_total the price_total to set
	 */
	public void setPrice_total(double price_total) {
		this.price_total = price_total;
	}
	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(LocalDate date_created) {
		this.date_created = date_created;
	}
	/**
	 * @param agency the agency to set
	 */
	public void setAgency(TravelAgency agency) {
		this.agency = agency;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param traveler the traveler to set
	 */
	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}
	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	/*
	 * OVERRIDE OBJECT METHOD
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_created == null) ? 0 : date_created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price_total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Itinerary other = (Itinerary) obj;
		if (date_created == null) {
			if (other.date_created != null)
				return false;
		} else if (!date_created.equals(other.date_created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price_total) != Double.doubleToLongBits(other.price_total))
			return false;
		return true;
	}
	
}
