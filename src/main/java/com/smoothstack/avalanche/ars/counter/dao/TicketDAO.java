package com.smoothstack.avalanche.ars.counter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.ars.counter.entity.Itinerary;
import com.smoothstack.avalanche.ars.counter.entity.Ticket;

@Repository
public interface TicketDAO extends JpaRepository<Ticket,Long>{

	@Query("SELECT ticket FROM Ticket ticket WHERE ticket.itinerary.id = :itinerary_id")
	List<Ticket> findTicketsByItinerary(@Param("itinerary_id") Long id);
}
