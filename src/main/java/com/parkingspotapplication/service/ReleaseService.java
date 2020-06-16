package com.parkingspotapplication.service;

import java.time.LocalDate;
import com.parkingspotapplication.dto.ResponseMessageDto;

public interface ReleaseService {
	/**
	 * 
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @return ResponseMessageDto
	 */
	public ResponseMessageDto releaseSpot(long employeeId,LocalDate startDate,LocalDate endDate);

}
