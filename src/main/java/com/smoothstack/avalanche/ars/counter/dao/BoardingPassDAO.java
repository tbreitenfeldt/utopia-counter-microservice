package com.smoothstack.avalanche.ars.counter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.avalanche.ars.counter.entity.BoardingPass;

@Repository
public interface BoardingPassDAO extends JpaRepository<BoardingPass,Long>{

}
