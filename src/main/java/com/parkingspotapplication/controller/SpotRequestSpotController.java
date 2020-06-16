package com.parkingspotapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingspotapplication.dto.ResponseMessageDto;
import com.parkingspotapplication.exception.NoFreeSpotsFoundException;
import com.parkingspotapplication.exception.RequestNotProcessedException;
import com.parkingspotapplication.exception.SpotRequestNotFoundException;
import com.parkingspotapplication.service.SpotRequestService;

@RestController
public class SpotRequestSpotController {
	
	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);
	@Autowired
	SpotRequestService spotRequestService;
	
	/**
	 * 
	 * @return ResponseEntity<ResponseMessageDto>
	 * @throws RequestNotProcessedException
	 * @throws SpotRequestNotFoundException
	 * @throws NoFreeSpotsFoundException
	 */
	@GetMapping("/lottery")
	public ResponseEntity<ResponseMessageDto> lottery() throws RequestNotProcessedException, SpotRequestNotFoundException, NoFreeSpotsFoundException{
		logger.info("this is for lottery system in controller");
		ResponseMessageDto responseMessageDto=spotRequestService.requestProcessing();
		return new ResponseEntity<ResponseMessageDto>(responseMessageDto,HttpStatus.OK);
		
	}

}
