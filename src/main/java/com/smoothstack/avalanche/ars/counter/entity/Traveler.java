package com.smoothstack.avalanche.ars.counter.entity;

import java.sql.Date;
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
@Table(name = "traveler")
public class Traveler {

		/*
		 * FIELDS
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name = "first_name")
		private String first_name;
		
		@Column(name = "last_name")
		private String last_name;
		
		@Column(name = "dob")
		private Date dob;
		
		@Column(name = "phone")
		private String phone;
		
		@Column(name = "email")
		private String email;
		
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
		 * ENTITY RELATIONSHIPS
		 */
		@OneToMany(mappedBy = "traveler",
				cascade = CascadeType.ALL,
				orphanRemoval = true)
		@JsonIgnore
		private List<Itinerary> itineraries;
		
		/*
		 * CONSTRUCTORS
		 */
		public Traveler() {}

		/**
		 * @param id
		 * @param first_name
		 * @param last_name
		 * @param dob
		 * @param phone
		 * @param email
		 * @param street
		 * @param country
		 * @param state
		 * @param city
		 * @param postal_code
		 */
		public Traveler(Long id, String first_name, String last_name, Date dob, String phone, String email,
				String street, String country, String state, String city, String postal_code) {
			this.id = id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.dob = dob;
			this.phone = phone;
			this.email = email;
			this.street = street;
			this.country = country;
			this.state = state;
			this.city = city;
			this.postal_code = postal_code;
		}

		public Traveler(String first_name, String last_name, Date dob, String phone, String email,
				String street, String country, String state, String city, String postal_code) {
			this.first_name = first_name;
			this.last_name = last_name;
			this.dob = dob;
			this.phone = phone;
			this.email = email;
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
		 * @return the first_name
		 */
		public String getFirst_name() {
			return first_name;
		}

		/**
		 * @return the last_name
		 */
		public String getLast_name() {
			return last_name;
		}

		/**
		 * @return the dob
		 */
		public Date getDob() {
			return dob;
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
		 * @return the postal_code
		 */
		public String getPostal_code() {
			return postal_code;
		}

		/**
		 * @return the itineraries
		 */
		public List<Itinerary> getItineraries() {
			return itineraries;
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
		 * @param first_name the first_name to set
		 */
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		/**
		 * @param last_name the last_name to set
		 */
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		/**
		 * @param dob the dob to set
		 */
		public void setDob(Date dob) {
			this.dob = dob;
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
		 * @param postal_code the postal_code to set
		 */
		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
		}
		/**
		 * @param itineraries the itineraries to set
		 */
		public void setItineraries(List<Itinerary> itineraries) {
			this.itineraries = itineraries;
		}

		/*
		 * OVERRIDE OBJECT METHOD
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((country == null) ? 0 : country.hashCode());
			result = prime * result + ((dob == null) ? 0 : dob.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
			Traveler other = (Traveler) obj;
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
			if (dob == null) {
				if (other.dob != null)
					return false;
			} else if (!dob.equals(other.dob))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (first_name == null) {
				if (other.first_name != null)
					return false;
			} else if (!first_name.equals(other.first_name))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (last_name == null) {
				if (other.last_name != null)
					return false;
			} else if (!last_name.equals(other.last_name))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
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
