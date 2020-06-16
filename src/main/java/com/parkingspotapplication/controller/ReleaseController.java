package com.parkingspotapplication.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parkingspotapplication.dto.ResponseMessageDto;
import com.parkingspotapplication.service.ReleaseService;
import com.parkingspotapplication.service.SpotRequestService;


@RestController
@RequestMapping("/release")
public class ReleaseController {
	@Autowired
	ReleaseService releaseService;
	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);
	
	/**
	 * 
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @return ResponseEntity<ResponseMessageDto>
	 */
	@PostMapping("")
	public ResponseEntity<ResponseMessageDto> releaseSpot(@RequestParam Long employeeId,@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate endDate){
		logger.info("this is for release spot controller");
		ResponseMessageDto responseMessageDto=releaseService.releaseSpot(employeeId,startDate,endDate);
		return new ResponseEntity<>(responseMessageDto, HttpStatus.CREATED);
		
	}

}
