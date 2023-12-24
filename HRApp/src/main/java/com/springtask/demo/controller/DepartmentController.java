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
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> fetchById(@PathVariable Long id){
		Department department = serviceImpl.fetchDeptById(id);
		return new ResponseEntity<>(department,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Department>> findAllDepts(){
		List<Department> findAllDepts = serviceImpl.findAllDepts();
		return new ResponseEntity<>(findAllDepts,HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Department> updateDept(@PathVariable Long id,Department dept){
		Department updateDept = serviceImpl.updateDept(id, dept);
		return new ResponseEntity<>(updateDept,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDept(@PathVariable Long id){
		serviceImpl.deleteDept(id);
	}
	

}
