package com.tnsif.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tnsif.employeeservice.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// This will be AUTO IMPLEMENTED by Spring into a Bean
}
