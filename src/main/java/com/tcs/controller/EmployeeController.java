package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.exception.RecordNotFoundException;
import com.tcs.model.Employee;
import com.tcs.repo.EmployeeRepo;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepoImpl;

	@GetMapping("/")
	public List<Employee> getAllData() {
		return this.employeeRepoImpl.findAll();
	}

	@GetMapping("/{employeeId}")
	public Employee getDataById(@PathVariable int employeeId) throws RecordNotFoundException {
		return this.employeeRepoImpl.findById(employeeId)
				.orElseThrow(() -> new RecordNotFoundException("Id NOt Exist"));
	}

	@PostMapping("/")
	public Employee saveData(@RequestBody Employee employee) {
		return this.employeeRepoImpl.save(employee);
	}

	@PutMapping("/{employeeId}")
	public Employee updateData(@RequestBody Employee employee, @PathVariable int employeeId)
			throws RecordNotFoundException {
		Employee employee2 = this.employeeRepoImpl.findById(employeeId)
				.orElseThrow(() -> new RecordNotFoundException("Id NOt Exist" + employeeId));
		employee2.setEmployeeName(employee.getEmployeeName());
		employee2.setEmployeeSalary(employee.getEmployeeSalary());
		employee2.setEmployeeEmail(employee.getEmployeeEmail());
		employee2.setPassword(employee.getPassword());
		return this.employeeRepoImpl.save(employee2);

	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Employee> deleteData(@PathVariable int employeeId) throws RecordNotFoundException {
		Employee employee = this.employeeRepoImpl.findById(employeeId)
				.orElseThrow(() -> new RecordNotFoundException("Id NOt Exist"));
		
		employee.setEmployeeName(employee.getEmployeeName());
		employee.setEmployeeSalary(employee.getEmployeeSalary());
		employee.setEmployeeEmail(employee.getEmployeeEmail());
		employee.setPassword(employee.getPassword());
		this.employeeRepoImpl.deleteById(employeeId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping
	public void deleteAllData() {
		this.employeeRepoImpl.deleteAll();
	}
}
