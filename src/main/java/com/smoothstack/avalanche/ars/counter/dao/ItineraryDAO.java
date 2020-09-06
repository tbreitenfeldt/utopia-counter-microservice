package com.smoothstack.avalanche.ars.counter.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.ars.counter.entity.Itinerary;

@Repository
public interface ItineraryDAO extends JpaRepository<Itinerary,Long>{

	Optional<Itinerary> findItineraryById(Long id);
	
	@Query("SELECT itineraries FROM Itinerary itineraries WHERE itineraries.traveler.id = :traveler_id")
	List<Itinerary> findItineraryByTravelerId(@Param("traveler_id") Long traveler_id);
}
