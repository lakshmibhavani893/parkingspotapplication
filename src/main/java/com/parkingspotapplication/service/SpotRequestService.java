package com.parkingspotapplication.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingspotapplication.dao.FreeSpotRepository;
import com.parkingspotapplication.dao.SpotRequestRepository;
import com.parkingspotapplication.dto.ResponseMessageDto;
import com.parkingspotapplication.exception.NoFreeSpotsFoundException;
import com.parkingspotapplication.exception.RequestNotProcessedException;
import com.parkingspotapplication.exception.SpotRequestNotFoundException;
import com.parkingspotapplication.model.FreeSpot;
import com.parkingspotapplication.model.SpotRequest;


/**
 * this SpotRequestService is for requestProcessing
 * 
 * @author bhavani version 1-1
 * @since 2020-06-15
 *
 */
@Service
public class SpotRequestService {
	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);

	@Autowired
	FreeSpotRepository freeSpotRepository;

	@Autowired
	SpotRequestRepository spotRequestRepository;

	/**
	 * 
	 * @return ResponseDto as status msg
	 * @throws RequestNotProcessedException
	 * @throws SpotRequestNotFoundException
	 * @throws NoFreeSpotsFoundException
	 */
	public ResponseMessageDto requestProcessing()
			throws RequestNotProcessedException, SpotRequestNotFoundException, NoFreeSpotsFoundException {
		LocalDate date = LocalDate.now();
		List<SpotRequest> employeeReq = spotRequestRepository.findByStartDateGreaterThanAndStatus(date, "not assigned");
		if (employeeReq.isEmpty()) {
			throw new SpotRequestNotFoundException("no requests found for spots");
		}
		List<Integer> spotrequestIds = employeeReq.stream().map(m -> m.getId()).collect(Collectors.toList());
		Integer spotRequestId = getRandomElement(spotrequestIds);
	
		logger.info(" spot request id" + "    " + spotRequestId);

		List<FreeSpot> freeSpots = freeSpotRepository.findByStartDateGreaterThanAndStatus(date, "not assigned");
		if (freeSpots.isEmpty()) {
			throw new NoFreeSpotsFoundException("free spots not available");
		}
		List<Integer> freeSpotIds = freeSpots.stream().map(m -> m.getId()).collect(Collectors.toList());
		
		
		for(int i=0;i<freeSpotIds.size();i++) {
		FreeSpot freeSpot = freeSpotRepository.findById(freeSpotIds.get(i)).get();
		for(int j=0;j<spotrequestIds.size();j++) 
			{
			SpotRequest spotRequest1=spotRequestRepository.findById(spotrequestIds.get(j)).get();
		
		logger.info("checking the dates");
		if (freeSpot.getStartDate().equals(spotRequest1.getStartDate())) {

			freeSpot.setStatus("assigned");
			spotRequest1.setFreeSpot(freeSpot);
			spotRequest1.setStatus("assigned");
			freeSpotRepository.save(freeSpot);
			spotRequestRepository.save(spotRequest1);
			break;

		} 
		
		}
		}
		
		ResponseMessageDto responseDto = new ResponseMessageDto();
		responseDto.setMessage("requests for parking spots hass been done");
		return responseDto;

	}
	
	public Integer getRandomElement(List<Integer> list) {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}
}