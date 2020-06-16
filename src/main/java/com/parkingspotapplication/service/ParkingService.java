package com.parkingspotapplication.service;

import java.util.List;

import com.parkingspotapplication.exception.EmployeeNotFoundException;
import com.parkingspotapplication.model.SpotRequest;

public interface ParkingService {
	/**
	 * 
	 * @param employeeId
	 * @return List<SpotRequest>
	 * @throws EmployeeNotFoundException
	 */
	public List<SpotRequest> getByEmployeeId(long employeeId) throws EmployeeNotFoundException;
}
