package com.parkingspotapplication.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.parkingspotapplication.dao.EmployeeRepository;
import com.parkingspotapplication.dao.SpotRequestRepository;
import com.parkingspotapplication.exception.EmployeeNotFoundException;
import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.SpotRequest;


@RunWith(MockitoJUnitRunner.Silent.class)
public class ParkingServiceImplTest {
	
	 @InjectMocks
	    ParkingServiceImpl parkingServiceImpl;
	    
	    @Mock
	    SpotRequestRepository SpotRequestRepository;
	    
	    @Mock
	    EmployeeRepository employeeRepository;
	    
	    @Test
	    public void TestGetTrainingsByCourseNameForPositive(){
	        
	       Employee employee=new Employee();
	       employee.setEmployeeId((long) 1);
	       employee.setEmployeeName("jansi");

	        
	        List<SpotRequest> spotRequests=new ArrayList<>();
	        SpotRequest spotRequest=new SpotRequest();
	        spotRequest.setEmployee(employee);
	        spotRequest.setId(1);
	        spotRequest.setStatus("assigned");
	        spotRequest.setStartDate(LocalDate.now());
	        spotRequests.add(spotRequest);
	        
	        Mockito.when(employeeRepository.findById((long) 1)).thenReturn(Optional.of(employee));
	        Mockito.when(SpotRequestRepository.findByEmployee(employee)).thenReturn(spotRequests);
	        
	        List<SpotRequest> result=parkingServiceImpl.getByEmployeeId(employee.getEmployeeId());
	        assertNotNull(result);
	        
	    }
	    
	    
	    @Test
	    public void TestGetTrainingsByCourseNameForNegative(){
	        
	       Employee employee=new Employee();
	       employee.setEmployeeId((long) -1);
	       employee.setEmployeeName("jansi");

	        
	        List<SpotRequest> spotRequests=new ArrayList<>();
	        SpotRequest spotRequest=new SpotRequest();
	        spotRequest.setEmployee(employee);
	        spotRequest.setId(-1);
	        spotRequest.setStatus("assigned");
	        spotRequest.setStartDate(LocalDate.now());
	        spotRequests.add(spotRequest);
	        
	        Mockito.when(employeeRepository.findById((long) -1)).thenReturn(Optional.of(employee));
	        Mockito.when(SpotRequestRepository.findByEmployee(employee)).thenReturn(spotRequests);
	        
	        List<SpotRequest> result=parkingServiceImpl.getByEmployeeId(employee.getEmployeeId());
	        assertNotNull(result);
	        
	    }
	    
	    
	    @Test(expected = EmployeeNotFoundException.class)
	    public void TestGetTrainingsByCourseNameForException() throws EmployeeNotFoundException{
	        
	       Employee employee=new Employee();
	       employee.setEmployeeId((long) 1);
	       employee.setEmployeeName("jansi");

	        
	        List<SpotRequest> spotRequests=new ArrayList<>();
	        SpotRequest spotRequest=new SpotRequest();
	        spotRequest.setEmployee(employee);
	        spotRequest.setId(-1);
	        spotRequest.setStatus("assigned");
	        spotRequest.setStartDate(LocalDate.now());
	        spotRequests.add(spotRequest);
	        
	        Mockito.when(employeeRepository.findById((long) 2)).thenReturn(Optional.of(employee));
	        Mockito.when(SpotRequestRepository.findByEmployee(employee)).thenReturn(spotRequests);
	        
	        List<SpotRequest> result=parkingServiceImpl.getByEmployeeId(employee.getEmployeeId());
	        assertNotNull(result);
	        
	    }
	    
	
	

}
