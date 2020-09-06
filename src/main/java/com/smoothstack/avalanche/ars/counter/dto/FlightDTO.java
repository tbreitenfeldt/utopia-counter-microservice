package com.smoothstack.avalanche.ars.counter.dto;

import java.sql.Date;

import com.smoothstack.avalanche.ars.counter.entity.Airport;

public class FlightDTO {

	/*
	 * FIELDS
	 */
	private Long id;
	private int capacity;
	private double price;
	private Date arrival_date;
	private Date departure_date;
	private Airport dest_airport;
	private Airport origin_airport;
	/*
	 * CONSTRUCTORS
	 */
	public FlightDTO() {}
	/**
	 * @param id
	 * @param dest
	 * @param origin
	 * @param capacity
	 * @param price
	 * @param arrival_date
	 * @param departure_date
	 */
	public FlightDTO(Long id, int capacity, double price, Date arrival_date, Date departure_date, Airport dest_airport, Airport origin_airport) {
		this.id = id;
		this.capacity = capacity;
		this.price = price;
		this.arrival_date = arrival_date;
		this.departure_date = departure_date;
		this.dest_airport = dest_airport;
		this.origin_airport = origin_airport;
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
	

}
