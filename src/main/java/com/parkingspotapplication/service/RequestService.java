package com.parkingspotapplication.service;

import java.time.LocalDate;

import com.parkingspotapplication.dto.ResponseMessageDto;

public interface RequestService {
	/**
	 * 
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @return ResponseMessageDto
	 */
	public ResponseMessageDto request(long employeeId,LocalDate startDate,LocalDate endDate);

}
