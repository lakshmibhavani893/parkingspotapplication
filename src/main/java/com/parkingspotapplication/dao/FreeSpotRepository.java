package com.parkingspotapplication.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkingspotapplication.model.FreeSpot;

public interface FreeSpotRepository extends JpaRepository<FreeSpot, Integer>{

	List<FreeSpot> findByStartDateGreaterThanAndStatus(LocalDate date, String string);


}
