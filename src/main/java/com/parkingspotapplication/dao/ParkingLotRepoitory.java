package com.parkingspotapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkingspotapplication.model.ParkingLot;

public interface ParkingLotRepoitory extends JpaRepository<ParkingLot, Integer>{

}
