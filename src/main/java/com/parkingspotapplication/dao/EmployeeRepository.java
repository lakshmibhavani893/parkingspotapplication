package com.parkingspotapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkingspotapplication.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
