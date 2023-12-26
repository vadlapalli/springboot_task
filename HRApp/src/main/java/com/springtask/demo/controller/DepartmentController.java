package com.springtask.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtask.demo.binding.Department;
import com.springtask.demo.entities.DepartmentEntity;
import com.springtask.demo.service.impl.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl serviceImpl;

	@PostMapping("/create")
	public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody Department department) {
		DepartmentEntity createdDepartment = serviceImpl.createDepartment(department);
		return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<DepartmentEntity> updateDepartment(@PathVariable Long id, @RequestBody Department department){
		DepartmentEntity updateDept = serviceImpl.updateDept(id, department);
		return new ResponseEntity<>(updateDept, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Department findDeptById(@PathVariable Long id){
		return serviceImpl.findDeptById(id);
	}
	
	@GetMapping("dept/{id}")
	public DepartmentEntity findDepartmetById(@PathVariable Long id){
		return serviceImpl.findDepartmentById(id);
	}
	
	
	@GetMapping("/")
	public List<DepartmentEntity> findAllDepts(){
		return serviceImpl.findAllDepts();
	}

	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		 serviceImpl.deleteDept(id);
	}

}
