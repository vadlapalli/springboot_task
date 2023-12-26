package com.springtask.demo.binding;

import java.util.List;

import com.springtask.demo.entities.EmployeeEntity;
import com.springtask.demo.entities.PositionEntity;

import lombok.Data;

@Data
public class Department {
	
	private String name;
	
	private List<PositionEntity> positions;
	
	private List<EmployeeEntity> employees;

}
