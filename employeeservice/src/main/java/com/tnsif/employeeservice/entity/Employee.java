package com.tnsif.employeeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id
    private Integer employeeId;
    private String name;
    private String position;
    private double salary;

    // New added fields
    private String department;
    private String email;
    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoining;

    private Double experience;
    private String address;

    public Employee() {
        super();
    }

    public Employee(Integer employeeId, String name, String position, double salary, String department,
                    String email, String phoneNumber, LocalDate dateOfJoining, Double experience,
                    String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfJoining = dateOfJoining;
        this.experience = experience;
        this.address = address;
    }

    // Getters & Setters
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    }    
    public String getPosition() {
        return position;
    }    
    public void setPosition(String position) {
        this.position = position;
    }    
    public double getSalary() {
        return salary;
    }    
    public void setSalary(double salary) {
        this.salary = salary;
    }    
    public String getDepartment() {
        return department;
    }    
    public void setDepartment(String department) {
        this.department = department;
    }    
    public String getEmail() {
        return email;
    }    
    public void setEmail(String email) {
        this.email = email;
    }    
    public String getPhoneNumber() {
        return phoneNumber;
    }    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }    
    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }    
    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }    
    public Double getExperience() {
        return experience;
    }    
    public void setExperience(Double experience) {
        this.experience = experience;
    }    
    public String getAddress() {
        return address;
    }    
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + ", position=" + position
                + ", salary=" + salary + ", department=" + department + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", dateOfJoining=" + dateOfJoining
                + ", experience=" + experience + ", address=" + address +  "]";
    }
}
