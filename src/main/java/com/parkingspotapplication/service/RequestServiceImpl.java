package com.parkingspotapplication.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingspotapplication.dao.EmployeeRepository;
import com.parkingspotapplication.dao.SpotRequestRepository;
import com.parkingspotapplication.dto.ResponseMessageDto;
import com.parkingspotapplication.exception.EmployeeNotFoundException;
import com.parkingspotapplication.exception.EnrollAlreadyDoneException;
import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.SpotRequest;

@Service
public class RequestServiceImpl implements RequestService{

	Logger logger = LoggerFactory.getLogger(SpotRequestService.class);
	
	@Autowired
SpotRequestRepository spotRequestRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @return ResponseMessageDto
	 */
	@Override
	public ResponseMessageDto request(long employeeId,LocalDate startDate,LocalDate endDate) {
	ResponseMessageDto response = new ResponseMessageDto();
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundException("employee not found"));
		logger.info("this is for request");
		LocalDate localDate = LocalDate.now();
		if(!employee.isVip()) {
			if(startDate.compareTo(localDate)>0) {
				int startDate1 = startDate.getDayOfMonth();
				int endDate1 = endDate.getDayOfMonth();
				int difference = endDate1-startDate1;
				if(difference<2) {
					SpotRequest spotRequest1=spotRequestRepository.findSpotRequestByEmployeeAndStartDate(employee,startDate);
					SpotRequest spotRequest2=spotRequestRepository.findSpotRequestByEmployeeAndStartDate(employee,endDate);
					if((spotRequest1==null)&&(spotRequest2==null)) {
						for(LocalDate date = startDate;date.compareTo(endDate)<=0;date = date.plusDays(1)) {
							SpotRequest spotRequest = new SpotRequest();
							spotRequest.setEmployee(employee);
							spotRequest.setStartDate(date);
							spotRequest.setStatus("not assigned");
							spotRequestRepository.save(spotRequest);
						}
						response.setMessage("The employee requested for spot is submitted successfully");
					}
					else {
						throw new EnrollAlreadyDoneException("already raised request");
					}
				}
				else {
					response.setMessage("Request is not submitted successfully");
					throw new EmployeeNotFoundException("you can only request for 2 days");
				}
			}
			else {
				response.setMessage("Request is not submitted successfully");
				throw new EmployeeNotFoundException("start date should be greater than todays date");
			}
		}
		else {
			response.setMessage("Request is not submitted successfully");
		}
		return response;
	}
}
