package com.springtask.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtask.demo.binding.Employee;
import com.springtask.demo.entities.EmployeeEntity;
import com.springtask.demo.exceptions.EmployeeNotFoundException;
import com.springtask.demo.repositories.EmployeeRepository;
import com.springtask.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public EmployeeEntity creatEmployee(Employee employee) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		return employeeRepo.save(entity);
	}

	@Override
	public EmployeeEntity updateEmployee(Long id, Employee employee) {
		Optional<EmployeeEntity> findById = employeeRepo.findById(id);
		if(findById.isPresent()) {
			EmployeeEntity entity = findById.get();
			System.out.println("Name :"+entity.getDepartment().getName());
			BeanUtils.copyProperties(employee, entity);
			return employeeRepo.save(entity);
		}else {
			throw new EmployeeNotFoundException("Employee not available with give id:"+id);
		}
		
	}

	@Override
	public EmployeeEntity fetchEmployeeById(Long id) {
		Optional<EmployeeEntity> findById = employeeRepo.findById(id);
		if(findById.isPresent()) {
			EmployeeEntity employeeEntity = findById.get();
			return employeeEntity;
		}else {
			throw new EmployeeNotFoundException("Employee not available with give id:"+id);
		}
		
	}

	@Override
	public List<EmployeeEntity> fetchAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepo.deleteById(id);
		
	}

}
