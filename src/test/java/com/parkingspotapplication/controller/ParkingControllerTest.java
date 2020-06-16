package com.parkingspotapplication.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.parkingspotapplication.model.SpotRequest;
import com.parkingspotapplication.service.ParkingServiceImpl;


@RunWith(MockitoJUnitRunner.Silent.class)
public class ParkingControllerTest {
	
	 @InjectMocks
	    ParkingController parkingController;
	    
	    @Mock
	     ParkingServiceImpl ParkingServiceImpl;
	  
	    
	    @Test
	    public void TestGetTrainingDetailsByCourseNameForPositive() {
	        List<SpotRequest> spotRequests=new ArrayList<>();
	        SpotRequest spotRequest=new SpotRequest();
	        spotRequest.setId(1);
	        spotRequest.setStatus("assigned");
	       spotRequests.add(spotRequest);
	        
	        Mockito.when(ParkingServiceImpl.getByEmployeeId(Mockito.anyInt())).thenReturn(spotRequests);
	        
	        ResponseEntity<List<SpotRequest>> result=parkingController.getEmployeeById(Mockito.anyInt());
	    }
	    
	    
	    @Test
	    public void TestGetTrainingDetailsByCourseNameForNegative() {
	        List<SpotRequest> spotRequests=new ArrayList<>();
	        SpotRequest spotRequest=new SpotRequest();
	        spotRequest.setId(-1);
	        spotRequest.setStatus("assigned");
	       spotRequests.add(spotRequest);
	        
	        Mockito.when(ParkingServiceImpl.getByEmployeeId(Mockito.anyInt())).thenReturn(spotRequests);
	        
	        ResponseEntity<List<SpotRequest>> result=parkingController.getEmployeeById(Mockito.anyInt());
	    }
	  

}
