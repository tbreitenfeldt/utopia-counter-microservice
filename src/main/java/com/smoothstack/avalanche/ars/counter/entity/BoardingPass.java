package com.smoothstack.avalanche.ars.counter.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "boarding_pass")
public class BoardingPass {

	/*
	 * FIELDS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "gate_number")
	private String gate_number;
	
	@Column(name = "terminal_number")
	private String terminal_number;

	/*
	 * ENTITY RELATIONSHIP
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;
	/*
	 * CONSTRUCTORS
	 */
	public BoardingPass(){}
	
	/**
	 * @param id
	 * @param gate_number
	 * @param terminal_number
	 */
	public BoardingPass(Long id, String gate_number, String terminal_number) {
		this.id = id;
		this.gate_number = gate_number;
		this.terminal_number = terminal_number;
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
	 * @return the gate_number
	 */
	public String getGate_number() {
		return gate_number;
	}
	/**
	 * @return the terminal_number
	 */
	public String getTerminal_number() {
		return terminal_number;
	}
	
	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
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
	 * @param gate_number the gate_number to set
	 */
	public void setGate_number(String gate_number) {
		this.gate_number = gate_number;
	}
	/**
	 * @param terminal_number the terminal_number to set
	 */
	public void setTerminal_number(String terminal_number) {
		this.terminal_number = terminal_number;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/*
	 * OVERRIDE OBJECT METHODS
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gate_number == null) ? 0 : gate_number.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((terminal_number == null) ? 0 : terminal_number.hashCode());
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
		BoardingPass other = (BoardingPass) obj;
		if (gate_number == null) {
			if (other.gate_number != null)
				return false;
		} else if (!gate_number.equals(other.gate_number))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (terminal_number == null) {
			if (other.terminal_number != null)
				return false;
		} else if (!terminal_number.equals(other.terminal_number))
			return false;
		return true;
	}
	
	
}
