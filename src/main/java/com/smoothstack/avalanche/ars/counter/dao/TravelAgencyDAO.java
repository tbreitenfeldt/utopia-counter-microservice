package com.smoothstack.avalanche.ars.counter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.ars.counter.entity.TravelAgency;

@Repository
public interface TravelAgencyDAO extends JpaRepository<TravelAgency,Long>{

}
