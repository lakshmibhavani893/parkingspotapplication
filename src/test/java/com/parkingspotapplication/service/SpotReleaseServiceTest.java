package com.parkingspotapplication.service;


import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.parkingspotapplication.dao.EmployeeParkingLotRepository;
import com.parkingspotapplication.dao.EmployeeRepository;
import com.parkingspotapplication.dao.FreeSpotRepository;
import com.parkingspotapplication.dto.ResponseMessageDto;
import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.EmployeeParkingLot;
import com.parkingspotapplication.model.ParkingLot;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SpotReleaseServiceTest {

	private static final LocalDate startDate = null;

	private static final LocalDate endDate = null;

	private static final Long employeeId = null;

	@InjectMocks
	ReleaseServiceImpl spotReleaseService;

	@Mock
	EmployeeRepository employeeRepository;
	@Mock
	FreeSpotRepository freeSpotRepository;
	@Mock
	EmployeeParkingLotRepository employeeParkingLotRepository;

	@Test(expected = NullPointerException.class)
	public void TestForSpotRelease() {

		EmployeeParkingLot employeparking = new EmployeeParkingLot();
		Employee employee = new Employee();
		employeparking.setParkingLotId(123);
		employeparking.setParkingLot(new ParkingLot());
		employeparking.setStatus("avialbel");
		ResponseMessageDto requestResponseDto = new ResponseMessageDto();
		requestResponseDto.setMessage("spot released successfully");
		Mockito.when(freeSpotRepository.save(Mockito.any())).thenReturn(employeparking);
		Mockito.when(employeeParkingLotRepository.findByEmployee(employee)).thenReturn(employeparking);

	ResponseMessageDto result = spotReleaseService.releaseSpot(employeeId, startDate, endDate);
	Assert.assertNull(result);

	}
	@Test(expected = NullPointerException.class)
	public void TestForSpotReleaseNegtive() {

		EmployeeParkingLot employeparking = new EmployeeParkingLot();
		Employee employee = new Employee();
		employee.setEmployeeId(-1L);
		employeparking.setParkingLotId(123);
		employeparking.setParkingLot(new ParkingLot());
		employeparking.setStatus("avialbel");
		ResponseMessageDto requestResponseDto = new ResponseMessageDto();
		requestResponseDto.setMessage("spot released successfully");
		Mockito.when(freeSpotRepository.save(Mockito.any())).thenReturn(employeparking);
		Mockito.when(employeeParkingLotRepository.findByEmployee(employee)).thenReturn(employeparking);

		ResponseMessageDto result = spotReleaseService.releaseSpot(employeeId, startDate, endDate);
		Assert.assertNull(result);

	}

}
