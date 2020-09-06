package com.smoothstack.avalanche.ars.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.smoothstack.avalanche.ars.counter.controller.CounterController;
import com.smoothstack.avalanche.ars.counter.dao.AirportDAO;
import com.smoothstack.avalanche.ars.counter.dao.FlightDAO;
import com.smoothstack.avalanche.ars.counter.dao.ItineraryDAO;
import com.smoothstack.avalanche.ars.counter.dao.TicketDAO;
import com.smoothstack.avalanche.ars.counter.dao.TravelerDAO;
import com.smoothstack.avalanche.ars.counter.dao.UserDAO;
import com.smoothstack.avalanche.ars.counter.dto.FlightDTO;
import com.smoothstack.avalanche.ars.counter.dto.ItineraryDTO;
import com.smoothstack.avalanche.ars.counter.dto.TravelerDTO;
import com.smoothstack.avalanche.ars.counter.entity.Airport;
import com.smoothstack.avalanche.ars.counter.entity.Flight;
import com.smoothstack.avalanche.ars.counter.entity.Itinerary;
import com.smoothstack.avalanche.ars.counter.entity.Ticket;
import com.smoothstack.avalanche.ars.counter.entity.Traveler;
import com.smoothstack.avalanche.ars.counter.entity.User;
import com.smoothstack.avalanche.ars.counter.service.CounterService;

import javassist.NotFoundException;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ControllerTest {

	@InjectMocks
	CounterController counterController;
	
	@Mock
	CounterService counterService;
	
	@TestConfiguration
	static class CounterControllerTestContextConfiguration{
		@Bean
		public CounterService counterService() {
			return new CounterService();
		}
		@Bean
		public CounterController counterController() {
			return new CounterController();
		}
	}
	
	@MockBean
	private ItineraryDAO itineraryDAO;
	
	@MockBean
	private AirportDAO airportDAO;
	
	@MockBean
	private TicketDAO ticketDAO;
	
	@MockBean
	private TravelerDAO travelerDAO;
	
	@MockBean
	private UserDAO userDAO;
	
	@MockBean
	private FlightDAO flightDAO;
	
	@BeforeEach
	public void setUp() throws NotFoundException, ParseException {
		User user = new User(Long.valueOf(1), "email","pw","TRAVELER", "firstname", "lastname", new Date(1,1,1),"111-111-1111","street","country","state","city","postal");
		Traveler traveler = new Traveler(Long.valueOf(1),"firstname","lastname", new Date(1,1,1),"111-111-1111","email","street","country","state","city","postal_code");
		Traveler traveler2 = new Traveler(Long.valueOf(2),"firstname2","lastname", new Date(1,1,1),"111-111-1111","email","street","country","state","city","postal_code"); 
		Airport airport1 = new Airport(Long.valueOf(1), "name1", "street1","country1","state1","city1","postalcode1");
		Airport airport2 = new Airport(Long.valueOf(2), "name2", "street2","country2","state2","city2","postalcode2");
		Flight flight = new Flight(Long.valueOf(1), 10, 10, new Date(2,2,2), new Date(1,1,1));
		Ticket ticket = new Ticket(Long.valueOf(1),"ACTIVE", "1A");
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		Itinerary itinerary = new Itinerary(Long.valueOf(1),10, LocalDate.now(), null, user,traveler, tickets);
		Itinerary itinerary2 = new Itinerary(Long.valueOf(2),10, LocalDate.now(), null, user,traveler, tickets);
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		List<Itinerary> itineraries2 = new ArrayList<Itinerary>();
		itineraries.add(itinerary);
		itineraries2.add(itinerary2);
		List<Traveler> travelers = new ArrayList<Traveler>();
		travelers.add(traveler);
		travelers.add(traveler2);
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(flight);
		Mockito.when(itineraryDAO.findAll()).thenReturn(itineraries);
		Mockito.when(itineraryDAO.findById(Long.valueOf(1))).thenReturn(Optional.of(itinerary));
		Mockito.when(itineraryDAO.findItineraryByTravelerId(Long.valueOf(2))).thenReturn(itineraries2);
		Mockito.when(itineraryDAO.save(itinerary)).thenReturn(itinerary);
		Mockito.when(ticketDAO.findById(Long.valueOf(1))).thenReturn(Optional.of(ticket));
		Mockito.when(travelerDAO.findAll()).thenReturn(travelers);
		Mockito.when(flightDAO.findAll()).thenReturn(flights);
		ResponseEntity<Itinerary> testGetResponseItinerary = new ResponseEntity<>(itinerary, new HttpHeaders(), HttpStatus.OK);
		ResponseEntity<List<Itinerary>> testItinerary = new ResponseEntity<>(itineraries, new HttpHeaders(), HttpStatus.OK);
		Mockito.when(counterController.readItineraries()).thenReturn(testItinerary);
		Mockito.when(counterController.readItinerariesByTraveler(Long.valueOf(1))).thenReturn(testItinerary);
		Mockito.when(counterController.readItineraryById(Long.valueOf(1))).thenReturn(testGetResponseItinerary);
		ResponseEntity<Long> testEntityPost = new ResponseEntity<>(HttpStatus.CREATED);
		ResponseEntity<Itinerary> testEntityDelete = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Mockito.when(counterController.createItinerary(Mockito.any(ItineraryDTO.class))).thenReturn(testEntityPost);
		Mockito.when(counterController.deleteItineraryById(Mockito.any(Long.class))).thenReturn(testEntityDelete);
		ResponseEntity<Ticket> testTicketEntity = new ResponseEntity<>(ticket, new HttpHeaders(), HttpStatus.OK);
		Mockito.when(counterController.readTicketsById(Mockito.any(Long.class))).thenReturn(testTicketEntity);
		ResponseEntity<List<Traveler>> testGetTravelerEntity = new ResponseEntity<>(travelers, new HttpHeaders(), HttpStatus.OK);
		Mockito.when(counterController.readTravelers()).thenReturn(testGetTravelerEntity);
		ResponseEntity<Traveler> testEntityPostTraveler = new ResponseEntity<>(HttpStatus.CREATED);
		Mockito.when(counterController.createTraveler(Mockito.any(TravelerDTO.class))).thenReturn(testEntityPost);
		Mockito.when(counterController.readTravelersByParams(Mockito.any(TravelerDTO.class))).thenReturn(testGetTravelerEntity);
		ResponseEntity<List<Flight>> testEntityGetFlights = new ResponseEntity<>(flights, new HttpHeaders(), HttpStatus.OK );
		Mockito.when(counterController.readFlightsByParams(Mockito.any(Flight.class))).thenReturn(testEntityGetFlights);
	}
	
	@Test
	public void testReadItineraries() {
		ResponseEntity<List<Itinerary>> testItineraries = counterController.readItineraries();
		assertEquals(testItineraries.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testGetItineraryById() {
		ResponseEntity<Itinerary> testItinerary = counterController.readItineraryById(Long.valueOf(1));
		assertEquals(testItinerary.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testGetItineraryByTraveler() {
		ResponseEntity<List<Itinerary>> testItineraries = counterController.readItinerariesByTraveler(Long.valueOf(1));
		assertEquals(testItineraries.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testCreateItinerary() throws ParseException {
		ItineraryDTO itineraryDTO = new ItineraryDTO();
		ResponseEntity<Long> testResponseEntity = counterController.createItinerary(itineraryDTO);
		assertEquals(testResponseEntity.getStatusCode(), HttpStatus.CREATED);
	}
	
	@Test
	public void testCancelItinerary() {
		ResponseEntity<Itinerary> testResponseEntity = counterController.deleteItineraryById(Long.valueOf(1));
		assertEquals(testResponseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
	}
	
	@Test
	public void testReadTickets() {
		ResponseEntity<Ticket> testResponseEntity = counterController.readTicketsById(Long.valueOf(1));
		assertEquals(testResponseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testReadTraveler() {
		ResponseEntity<List<Traveler>> testResponseEntity = counterController.readTravelers();
		assertEquals(testResponseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testCreateTraveler() {
		ResponseEntity<Long> testResponseEntity = counterController.createTraveler(new TravelerDTO());
		assertEquals(testResponseEntity.getStatusCode(),HttpStatus.CREATED);
	}
	
	@Test
	public void testSearchTravelerByParam(){
		ResponseEntity<List<Traveler>> testResponseEntity = counterController.readTravelersByParams(new TravelerDTO());
		assertEquals(testResponseEntity.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testSearchFlightByParam() {
		ResponseEntity<List<Flight>> testResponseEntity = counterController.readFlightsByParams(new Flight());
		assertEquals(testResponseEntity.getStatusCode(), HttpStatus.OK);
	}
}
