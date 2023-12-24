package com.springtask.demo.service;


import java.util.List;

import com.springtask.demo.entities.Department;

public interface DepartmentService {
	
	public Department createDepartment(Department deptEntity);
	
	public Department fetchDeptById(Long Id);
	
	public List<Department> findAllDepts();
	
	public Department updateDept(Long id, Department dept);
	
	public void deleteDept(Long id);
	

}
