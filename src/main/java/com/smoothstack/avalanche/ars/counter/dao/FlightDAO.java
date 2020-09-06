package com.smoothstack.avalanche.ars.counter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.ars.counter.entity.Flight;

@Repository
public interface FlightDAO extends JpaRepository<Flight,Long>{

}
