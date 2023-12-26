package com.springtask.demo.binding;

import java.util.List;

import com.springtask.demo.entities.DepartmentEntity;
import com.springtask.demo.entities.SalaryEntity;

import lombok.Data;

@Data
public class Position {
	
	private String name;
	
	private DepartmentEntity department;
	
	private List<SalaryEntity> salaries;

}
