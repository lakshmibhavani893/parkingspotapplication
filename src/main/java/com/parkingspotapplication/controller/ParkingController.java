package com.parkingspotapplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.parkingspotapplication.exception.EmployeeNotFoundException;
import com.parkingspotapplication.model.SpotRequest;
import com.parkingspotapplication.service.ParkingService;
import com.parkingspotapplication.service.SpotRequestService;

@RestController
@RequestMapping("/employee")
public class ParkingController {
	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);
	@Autowired
	ParkingService parkingService;
	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws SpotRequestNotFoundException
	 */
	@GetMapping("/search")
	public ResponseEntity<List<SpotRequest>> getEmployeeById(@RequestParam long  employeeId) throws EmployeeNotFoundException {
		logger.info("this is for list of spot in controller");
		List<SpotRequest> EmployeeParkingLot = parkingService.getByEmployeeId(employeeId);
		return new ResponseEntity<>(EmployeeParkingLot, HttpStatus.OK);
	}

}
