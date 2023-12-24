package com.springtask.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtask.demo.entities.Department;
import com.springtask.demo.entities.Position;
import com.springtask.demo.entities.Salary;
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

}
