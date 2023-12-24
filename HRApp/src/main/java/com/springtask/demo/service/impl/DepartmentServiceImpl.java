package com.springtask.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtask.demo.entities.Department;
import com.springtask.demo.entities.Position;
import com.springtask.demo.entities.Salary;
import com.springtask.demo.exceptions.DepartmentNotFoundException;
import com.springtask.demo.repositories.DepartmentRepository;
import com.springtask.demo.service.DepartmentService;

import jakarta.transaction.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	@Transactional
	public Department createDepartment(Department deptEntity) {
		if (deptEntity.getPositions() != null) {
			for (Position position : deptEntity.getPositions()) {
				position.setDepartment(deptEntity);
				if (position.getSalaries() != null) {
					for (Salary salary : position.getSalaries()) {
						salary.setPosition(position);
					}
				}
			}

		}
		return deptRepo.save(deptEntity);
	}

	@Override
	public Department fetchDeptById(Long Id) {
		Optional<Department> findById = deptRepo.findById(Id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
	       throw new DepartmentNotFoundException("Department not found with ID: " + Id);
	    }
	}

	@Override
	public List<Department> findAllDepts() {
		 return deptRepo.findAll();
	}

	@Override
	public Department updateDept(Long id, Department dept) {
		Optional<Department> byId = deptRepo.findById(id);
		 if (byId.isPresent()) {
		        Department oldDept = byId.get();
		        if (dept.getPositions() != null) {
		            for (Position position : dept.getPositions()) {
		                position.setDepartment(oldDept);
		                if (position.getSalaries() != null) {
		                    for (Salary salary : position.getSalaries()) {
		                        salary.setPosition(position);
		                    }
		                }
		            }
		            oldDept.setPositions(dept.getPositions()); // Update the positions
		        }
		        BeanUtils.copyProperties(dept, oldDept);
		        return deptRepo.save(oldDept);
			
		}else{
			throw new DepartmentNotFoundException("Department not found with ID: " + id);
		}
	}

	@Override
	public void deleteDept(Long id) {
		deptRepo.deleteById(id);
		
	}

}
