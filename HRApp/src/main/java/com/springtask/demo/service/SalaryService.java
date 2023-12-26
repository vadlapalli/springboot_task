package com.springtask.demo.service;

import java.util.List;

import com.springtask.demo.binding.Salary;
import com.springtask.demo.entities.SalaryEntity;

public interface SalaryService {
	
	public SalaryEntity postSalary(Salary salary);
	
	public SalaryEntity updateSalary(Long id, Salary salaryForm);
	
	public SalaryEntity fetchSalaryById(Long id);
	
	public List<SalaryEntity> fetchAllSalaries();
	
	public void deleteSalaryById(Long id);

}
