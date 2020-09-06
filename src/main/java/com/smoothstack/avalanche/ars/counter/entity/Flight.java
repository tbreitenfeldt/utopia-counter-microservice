package com.smoothstack.avalanche.ars.counter.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	/*
	 * FIELDS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "arrival_date")
	private Date arrival_date;
	
	@Column(name = "departure_date")
	private Date departure_date;

	/*
	 * ENTITY RELATIONSHIPS
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dest")
	private Airport dest_airport;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "origin")
	private Airport origin_airport;
	/*
	 * CONSTRUCTORS
	 */
	public Flight() {}
	/**
	 * @param id
	 * @param dest
	 * @param origin
	 * @param capacity
	 * @param price
	 * @param arrival_date
	 * @param departure_date
	 */
	public Flight(Long id, int capacity, double price, Date arrival_date, Date departure_date) {
		this.id = id;
		this.capacity = capacity;
		this.price = price;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
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
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @return the arrival_date
	 */
	public Date getArrival_date() {
		return arrival_date;
	}
	/**
	 * @return the departure_date
	 */
	public Date getDeparture_date() {
		return departure_date;
	}
	
	/**
	 * @return the dest_airport
	 */
	public Airport getDest_airport() {
		return dest_airport;
	}
	/**
	 * @return the origin_airport
	 */
	public Airport getOrigin_airport() {
		return origin_airport;
	}
	/*
	 * SETTERS
	 */	
	/**
	 * @param dest_airport the dest_airport to set
	 */
	public void setDest_airport(Airport dest_airport) {
		this.dest_airport = dest_airport;
	}
	/**
	 * @param origin_airport the origin_airport to set
	 */
	public void setOrigin_airport(Airport origin_airport) {
		this.origin_airport = origin_airport;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @param arrival_date the arrival_date to set
	 */
	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}
	/**
	 * @param departure_date the departure_date to set
	 */
	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}
	
	/*
	 * OVERRIDE OBJECT METHODS
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrival_date == null) ? 0 : arrival_date.hashCode());
		result = prime * result + capacity;
		result = prime * result + ((departure_date == null) ? 0 : departure_date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
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
		Flight other = (Flight) obj;
		if (arrival_date == null) {
			if (other.arrival_date != null)
				return false;
		} else if (!arrival_date.equals(other.arrival_date))
			return false;
		if (capacity != other.capacity)
			return false;
		if (departure_date == null) {
			if (other.departure_date != null)
				return false;
		} else if (!departure_date.equals(other.departure_date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	
}
