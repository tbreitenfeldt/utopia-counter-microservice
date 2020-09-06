package com.smoothstack.avalanche.ars.counter.dto;


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.smoothstack.avalanche.ars.counter.entity.Ticket;
import com.smoothstack.avalanche.ars.counter.entity.TravelAgency;
import com.smoothstack.avalanche.ars.counter.entity.Traveler;
import com.smoothstack.avalanche.ars.counter.entity.User;

public class ItineraryDTO {

	private Long id;
	private User user;
	private TravelAgency agency;
	private Traveler traveler;
	private List<Ticket> tickets;
	private Double price_total;
	private String date_created;
	
	public ItineraryDTO() {}
	/**
	 * @param id
	 * @param user
	 * @param agency
	 * @param traveler
	 * @param tickets
	 * @param date_created
	 */
	public ItineraryDTO(Long id, User user, TravelAgency agency, Traveler traveler, List<Ticket> tickets,
			Double price_total, String date_created) {
		super();
		this.id = id;
		this.user = user;
		this.agency = agency;
		this.traveler = traveler;
		this.tickets = tickets;
		this.price_total = price_total;
		this.date_created = date_created;
	}
	/*
	 * GET CURRENT DATE
	 */

	public LocalDate getSubmissionDateConverted(String timezone) throws java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		Date date = dateFormat.parse(this.date_created);
		
		//Getting the default zone id
		ZoneId defaultZoneId = ZoneId.systemDefault();
			
		//Converting the date to Instant
		Instant instant = date.toInstant();
		return instant.atZone(defaultZoneId).toLocalDate();
		
	}
	public void setSubmissionDate(Date date, String timezone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		this.date_created = dateFormat.format(date_created);
	}
	
	//GETTERS
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the agency
	 */
	public TravelAgency getAgency() {
		return agency;
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
	public Double getPrice_total() {
		return price_total;
	}
	//SETTERS
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param agency the agency to set
	 */
	public void setAgency(TravelAgency agency) {
		this.agency = agency;
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
	
	public void setPrice_total(double price_total) {
		this.price_total = price_total;
	}
}
