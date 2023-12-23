package com.springtask.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtask.demo.entities.Department;
import com.springtask.demo.repositories.DepartmentRepository;
import com.springtask.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public Department createDepartment(Department deptEntity) {
		return deptRepo.save(deptEntity);
	}

	@Override
	public List<Department> fetchDepartments() {
		List<Department> findAll = deptRepo.findAll();
		return findAll;
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Optional<Department> findById = deptRepo.findById(id);
		if(findById.isPresent()) {
			Department dept = findById.get();
			BeanUtils.copyProperties(department, dept);
			deptRepo.save(dept);
			return dept;
		}
		return null;
	}

	@Override
	public Department fetchDeptById(Long id) {
		Optional<Department> optional = deptRepo.findById(id);
		if(optional.isPresent()) {
			Department department = optional.get();
			return department;
		}
		
		return null;
	}

	@Override
	public void deleteDeptById(Long Id) {
		deptRepo.deleteById(Id);
		
	}


}
