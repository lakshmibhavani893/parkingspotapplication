package com.parkingspotapplication.dto;

import java.time.LocalDate;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.FreeSpot;

public class SpotRequestDto {

	private int id;

	@OneToOne()
	private FreeSpot freeSpot;

	@JsonIgnore
	@OneToOne()
	private Employee employee;

	@JsonIgnore
	private LocalDate startDate;

	@JsonIgnore
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FreeSpot getFreeSpot() {
		return freeSpot;
	}

	public void setFreeSpot(FreeSpot freeSpot) {
		this.freeSpot = freeSpot;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
