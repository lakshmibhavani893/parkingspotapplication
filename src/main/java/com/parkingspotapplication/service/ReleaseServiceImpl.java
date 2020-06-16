package com.parkingspotapplication.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingspotapplication.dao.EmployeeParkingLotRepository;
import com.parkingspotapplication.dao.EmployeeRepository;
import com.parkingspotapplication.dao.FreeSpotRepository;
import com.parkingspotapplication.dto.ResponseMessageDto;
import com.parkingspotapplication.exception.EmployeeNotFoundException;
import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.EmployeeParkingLot;
import com.parkingspotapplication.model.FreeSpot;

@Service
public class ReleaseServiceImpl implements ReleaseService{

	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);
	@Autowired
	EmployeeParkingLotRepository employeeParkingLotRepository;
	
	@Autowired
	FreeSpotRepository freeSpotRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @return ResponseMessageDto
	 */
	@Override
	public ResponseMessageDto releaseSpot(long employeeId,LocalDate startDate,LocalDate endDate) {
		
		logger.info("this is for release spot");
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		}

		else {
			throw new EmployeeNotFoundException("employee not found");

		}
		EmployeeParkingLot employeeParkingLot = employeeParkingLotRepository.findByEmployee(employee);
		if (employee.isVip()) {
			for (LocalDate dates = startDate; dates
					.isBefore(endDate.plusDays(1)); dates = dates.plusDays(1)) {
				
				FreeSpot freeespot = new FreeSpot();
				freeespot.setEmployee(employee);
				System.out.println(employee);
				freeespot.setParkingLot(employeeParkingLot.getParkingLot());
				freeespot.setStatus("not assigned");
				freeespot.setStartDate(dates);
				freeSpotRepository.save(freeespot);
			}
		ResponseMessageDto requestResponseDto = new ResponseMessageDto();
			requestResponseDto.setMessage("spot released successfully");
			return requestResponseDto;

		} else {

			throw new EmployeeNotFoundException("employee is not vip ");
		}
	}

}
