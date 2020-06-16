package com.parkingspotapplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkingspotapplication.dao.EmployeeRepository;
import com.parkingspotapplication.dao.SpotRequestRepository;
import com.parkingspotapplication.exception.EmployeeNotFoundException;
import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.SpotRequest;

@Service
public class ParkingServiceImpl implements ParkingService{

	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);
	@Autowired
	SpotRequestRepository spotRequestRepository;

	@Autowired
	EmployeeRepository employeeRepository;
/**
     * @param employeeId
	 * @return List<SpotRequest>
	 * @throws EmployeeNotFoundException
 */
	public List<SpotRequest> getByEmployeeId(long employeeId) throws  EmployeeNotFoundException {
		logger.info("this is for list of spos allocated to employee");
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundException("Employee with give id not found"));
			List<SpotRequest> spotRequests = spotRequestRepository.findByEmployee(employee);
			if(spotRequests.isEmpty()) {
				throw new EmployeeNotFoundException("request not found");
			}
			else {
				return spotRequests;
			}
			
			
	}
}
