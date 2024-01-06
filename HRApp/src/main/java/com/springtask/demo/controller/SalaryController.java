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

import com.springtask.demo.binding.Salary;
import com.springtask.demo.entities.SalaryEntity;
import com.springtask.demo.service.impl.SalaryServiceImpl;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
	
	
	private SalaryServiceImpl serviceImpl;
	
	public SalaryController(SalaryServiceImpl serviceImpl) {
		super();
		this.serviceImpl = serviceImpl;
	}

	@PostMapping("/post")
	public SalaryEntity postSalary(@RequestBody Salary salary) {
		return serviceImpl.postSalary(salary);
	}
	
	@PutMapping("/update/{id}")
	public SalaryEntity updateSalary(@PathVariable Long id, @RequestBody Salary salary) {
		return serviceImpl.updateSalary(id, salary);
	}
	
	
	@GetMapping("/{id}")
	public SalaryEntity findSalaryById(@PathVariable Long id) {
		return serviceImpl.fetchSalaryById(id);
	}
	
	@GetMapping("/")
	public List<SalaryEntity> fetchAllSalaries(){
		return serviceImpl.fetchAllSalaries();
	}
	
	@DeleteMapping("/{id}")
	public void deleteSlaryById(@PathVariable Long id) {
		serviceImpl.deleteSalaryById(id);
	}
	

}
