package com.tcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor 
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue   //(strategy = GenerationType.IDENTITY)
	private int employeeId;
	private String employeeName;
	private double employeeSalary;
	private String employeeEmail;
	private String password;
	
	/*
	 * public String getEmployeeName() { return employeeName; } public void
	 * setEmployeeName(String employeeName) { this.employeeName = employeeName; }
	 * public double getEmployeeSalary() { return employeeSalary; } public void
	 * setEmployeeSalary(double employeeSalary) { this.employeeSalary =
	 * employeeSalary; } public String getEmployeeEmail() { return employeeEmail; }
	 * public void setEmployeeEmail(String employeeEmail) { this.employeeEmail =
	 * employeeEmail; } public String getPassword() { return password; } public void
	 * setPassword(String password) { this.password = password; }
	 */
	
	
	
	
}
