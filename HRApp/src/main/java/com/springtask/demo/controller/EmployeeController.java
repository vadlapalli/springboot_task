package com.springtask.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtask.demo.binding.Employee;
import com.springtask.demo.entities.EmployeeEntity;
import com.springtask.demo.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeServiceImpl serviceImpl;
	
	public EmployeeController(EmployeeServiceImpl serviceImpl) {
		this.serviceImpl=serviceImpl;
	}
	
	
	@PostMapping("/create")
	public EmployeeEntity creatEmplyee(@RequestBody Employee employee) {
		return serviceImpl.creatEmployee(employee);
	}
	
	@PutMapping("/update/{id}")
	public EmployeeEntity updateEmplyee(@PathVariable Long id, @RequestBody Employee employee) {
		return serviceImpl.updateEmployee(id,employee);
	}
	
	@GetMapping("/{id}")
	public EmployeeEntity fetchEmployeeById(@PathVariable Long id) {
		return serviceImpl.fetchEmployeeById(id);
	}
	
	@GetMapping("/")
	public List<EmployeeEntity> fetchAllEmployees(){
		return serviceImpl.fetchAllEmployees();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		serviceImpl.deleteEmployeeById(id);
	}

}
