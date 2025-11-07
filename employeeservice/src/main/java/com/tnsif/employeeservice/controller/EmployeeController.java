package com.tnsif.employeeservice.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tnsif.employeeservice.entity.Employee;
import com.tnsif.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employeeservices")   // Base path changed here
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Retrieve all employees
    @GetMapping
    public List<Employee> listAll() {
        return employeeService.listAll();
    }

    // Retrieve employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Integer id) {
        try {
            Employee employee = employeeService.get(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create new employee
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update employee by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) {
        try {
            Employee existingEmployee = employeeService.get(id);

            existingEmployee.setName(employee.getName());
            existingEmployee.setPosition(employee.getPosition());
            existingEmployee.setSalary(employee.getSalary());

            // Additional fields
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
            existingEmployee.setDateOfJoining(employee.getDateOfJoining());
            existingEmployee.setExperience(employee.getExperience());
            existingEmployee.setAddress(employee.getAddress());

            employeeService.save(existingEmployee);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
