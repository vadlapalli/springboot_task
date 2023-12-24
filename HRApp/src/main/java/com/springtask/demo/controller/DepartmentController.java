package com.springtask.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	

}
