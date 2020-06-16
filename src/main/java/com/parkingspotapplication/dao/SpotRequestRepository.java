package com.parkingspotapplication.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.SpotRequest;

public interface SpotRequestRepository extends JpaRepository<SpotRequest, Integer>{

	List<SpotRequest> findByStartDateGreaterThanAndStatus(LocalDate date, String string);
	List<SpotRequest> findByEmployee(Employee employee);
	SpotRequest findSpotRequestByEmployeeAndStartDate(Employee employee, LocalDate startDate);

}
