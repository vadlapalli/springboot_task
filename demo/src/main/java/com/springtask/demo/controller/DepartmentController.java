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

import com.springtask.demo.entities.Department;
import com.springtask.demo.service.impl.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl serviceImpl;

	@PostMapping("/createDepartment")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
		Department createdDepartment = serviceImpl.createDepartment(department);
		return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Department>> fetchDepartments(){
		List<Department> fetchDepartments = serviceImpl.fetchDepartments();
		return new ResponseEntity<>(fetchDepartments, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<Department> fetchDepyById(@PathVariable Long id){
		Department deptById = serviceImpl.fetchDeptById(id);
		return new ResponseEntity<>(deptById, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateDept/{id}")
	public ResponseEntity<Department> updateDept(@PathVariable Long id, @RequestBody Department dept) {
		Department updateDepartment = serviceImpl.updateDepartment(id, dept);
		return new ResponseEntity<>(updateDepartment, HttpStatus.CREATED);
	}
	 
	@DeleteMapping("/DeleteById/{id}")
	public void deleteDepyById(@PathVariable Long id){
		serviceImpl.deleteDeptById(id);
	}

}
