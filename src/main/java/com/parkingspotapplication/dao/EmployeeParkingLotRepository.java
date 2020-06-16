package com.parkingspotapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkingspotapplication.model.Employee;
import com.parkingspotapplication.model.EmployeeParkingLot;

public interface EmployeeParkingLotRepository extends JpaRepository<EmployeeParkingLot, Integer>{

	EmployeeParkingLot findByEmployee(Employee employee);

}
