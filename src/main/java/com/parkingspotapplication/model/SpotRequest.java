package com.parkingspotapplication.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class SpotRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@OneToOne()
	private FreeSpot freeSpot;
	
	@JsonIgnore
	@OneToOne()
	private Employee employee;
	
	private LocalDate startDate;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SpotRequest() {
		super();
	}

	public SpotRequest(FreeSpot freeSpot, Employee employee, String status) {
		super();
		this.freeSpot = freeSpot;
		this.employee = employee;
		this.status = status;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	

}
