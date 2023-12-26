package com.springtask.demo.service;


import java.util.List;

import com.springtask.demo.binding.Department;
import com.springtask.demo.entities.DepartmentEntity;

public interface DepartmentService {
	
	public DepartmentEntity createDepartment(Department deptform);
	
	public DepartmentEntity updateDept(Long id, Department dept);
	
	public Department findDeptById(Long id);
	
	public DepartmentEntity findDepartmentById(Long id);
	
	public List<DepartmentEntity> findAllDepts();
	
	public void deleteDept(Long id);


}
