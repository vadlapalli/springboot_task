package com.springtask.demo.service;

import java.util.List;

import com.springtask.demo.binding.Employee;
import com.springtask.demo.entities.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity creatEmployee(Employee employee);
	
	public EmployeeEntity updateEmployee(Long id,Employee employee);
	
	public EmployeeEntity fetchEmployeeById(Long id);
	
	public List<EmployeeEntity> fetchAllEmployees();
	
	public void deleteEmployeeById(Long id);

}
