package com.springtask.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.springtask.demo.binding.Department;
import com.springtask.demo.entities.DepartmentEntity;
import com.springtask.demo.exceptions.DepartmentNotFoundException;
import com.springtask.demo.repositories.DepartmentRepository;
import com.springtask.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository deptRepo;
	
	public DepartmentServiceImpl(DepartmentRepository deptRepo) {
		super();
		this.deptRepo = deptRepo;
	}

	@Override
	public DepartmentEntity createDepartment(Department deptform) {
		DepartmentEntity enitity = new DepartmentEntity();
		BeanUtils.copyProperties(deptform, enitity);
		return deptRepo.save(enitity);
	}

	@Override
	public DepartmentEntity updateDept(Long id, Department dept) {
		Optional<DepartmentEntity> byId = deptRepo.findById(id);
		if(byId.isPresent()) {
			DepartmentEntity enitity = byId.get();
			BeanUtils.copyProperties(dept, enitity);
			return deptRepo.save(enitity);
		}else {
			throw  new DepartmentNotFoundException("Department not found with the given id:"+id);
		}
		
	}

	@Override   
	public Department findDeptById(Long id) {
		Optional<DepartmentEntity> byId = deptRepo.findById(id);
		if(byId.isPresent()) {
			DepartmentEntity departmentEntity = byId.get();	
			return mapDepartmentEntityToDepartment(departmentEntity);
		}else {
			throw  new DepartmentNotFoundException("Department not found with the given id:"+id);
		}
	}
	
	private Department mapDepartmentEntityToDepartment(DepartmentEntity departmentEntity) {
	    Department department = new Department();
	    department.setName(departmentEntity.getName());
	    // Add other properties as needed
	    
	    return department;
	}

	@Override
	public DepartmentEntity findDepartmentById(Long id) {
		Optional<DepartmentEntity> findById = deptRepo.findById(id);
		if(findById.isPresent()) { 
			return findById.get();
		}else {
			throw  new DepartmentNotFoundException("Department not found with the given id:"+id);
		}
	}

	@Override
	public List<DepartmentEntity> findAllDepts() { 
		return deptRepo.findAll();
	}

	@Override
	public void deleteDept(Long id) {
		deptRepo.deleteById(id);
		
	}

	
}
