package com.springtask.demo.service;

import java.util.List;

import com.springtask.demo.entities.Department;

public interface DepartmentService {
	
	public Department createDepartment(Department deptEntity);
	
	public List<Department> fetchDepartments();
	
	public Department fetchDeptById(Long id);
	
    public Department updateDepartment(Long id,Department department);
    
    public void deleteDeptById(Long Id);

}