package com.parkingspotapplication.controller;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.parkingspotapplication.dto.ResponseMessageDto;
import com.parkingspotapplication.service.ReleaseService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SpotReleaseControllerTest {
	private static final LocalDate endDate = null;

	private static final Long employeeId = null;

	private static final LocalDate startDate = null;

	@InjectMocks
	ReleaseController spotReleaseController;
    
    @Mock
    ReleaseService sportReleaseservice;
    @Test(expected=NullPointerException.class)
    public void TestForSportReleaseForTest() {
        
    	ResponseMessageDto response=new ResponseMessageDto();
    	response.setMessage("paraking12");
        Mockito.when(sportReleaseservice.releaseSpot(employeeId, startDate, endDate)).thenReturn(response);
        ResponseEntity<ResponseMessageDto> result=spotReleaseController.releaseSpot(employeeId, startDate, endDate);
        assertNotNull(result);
        
    }
    @Test(expected=NullPointerException.class)
    public void TestForSportReleaseForTestNegtive() {
        
    	ResponseMessageDto response=new ResponseMessageDto();
    	response.setMessage("sucess");
        Mockito.when(sportReleaseservice.releaseSpot(employeeId, startDate, endDate)).thenReturn(response);
        ResponseEntity<ResponseMessageDto> result=spotReleaseController.releaseSpot(employeeId, startDate, endDate);
        assertNotNull(result);
        
    }
 

}
