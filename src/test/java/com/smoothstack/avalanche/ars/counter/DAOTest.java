package com.smoothstack.avalanche.ars.counter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.smoothstack.avalanche.ars.counter.dao.ItineraryDAO;
import com.smoothstack.avalanche.ars.counter.entity.Itinerary;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DAOTest {
	
	@Autowired
	ItineraryDAO itineraryDAO;

	
	//test setup
	@BeforeEach
	void setUp() throws Exception{
		
	}
	
	@Test
	public void testFindItineraryByTravelerId() {
	
		List<Itinerary> itineraryByTravelerTrue = itineraryDAO.findItineraryByTravelerId(Long.valueOf(18));
		List<Itinerary> itineraryByTravelerFalse = itineraryDAO.findItineraryByTravelerId(Long.valueOf(2));
		assertTrue(itineraryByTravelerTrue.size()==2);
		assertFalse(itineraryByTravelerFalse.size()==5);
		
	}
	
}
