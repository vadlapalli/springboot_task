package com.springtask.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtask.demo.binding.Salary;
import com.springtask.demo.entities.SalaryEntity;
import com.springtask.demo.exceptions.SalaryNotFoundException;
import com.springtask.demo.repositories.SalaryRepository;
import com.springtask.demo.service.SalaryService;


@Service
public class SalaryServiceImpl implements SalaryService {
	
	@Autowired
	private SalaryRepository salaryRepo;

	@Override
	public SalaryEntity postSalary(Salary salary) {
		SalaryEntity entity = new SalaryEntity();
		BeanUtils.copyProperties(salary, entity);
		return salaryRepo.save(entity);
	}

	@Override
	public SalaryEntity updateSalary(Long id, Salary salaryForm) {
		Optional<SalaryEntity> findById = salaryRepo.findById(id);
		if(findById.isPresent()) {
			SalaryEntity entity = findById.get();
			BeanUtils.copyProperties(salaryForm, entity);
			return salaryRepo.save(entity);
		}else{
			throw new SalaryNotFoundException("Salary not found with ID: " + id);
		}
	}

	@Override
	public SalaryEntity fetchSalaryById(Long id) {
		Optional<SalaryEntity> findById = salaryRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else{
			throw new SalaryNotFoundException("Salary not found with ID: " + id);
		}
		
	}

	@Override
	public List<SalaryEntity> fetchAllSalaries() {
		return salaryRepo.findAll();
	}

	@Override
	public void deleteSalaryById(Long id) {
		salaryRepo.deleteById(id);
		
	}

}
