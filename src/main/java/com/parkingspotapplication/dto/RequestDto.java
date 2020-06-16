package com.parkingspotapplication.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class RequestDto {
	
	@NotNull
	private Long employeeId;
	@NotEmpty
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@NotEmpty
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	

}
