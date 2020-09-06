package com.smoothstack.avalanche.ars.counter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.ars.counter.entity.Airport;

@Repository
public interface AirportDAO extends JpaRepository<Airport, Long>{

}
