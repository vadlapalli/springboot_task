package com.springtask.demo.binding;

import com.springtask.demo.entities.PositionEntity;

import lombok.Data;

@Data
public class Salary {

	private double basicSalary;

	private double hra;

	private double da;
	
	private double grossSalary;
	
	private double otherAllowances;
	
	private PositionEntity position;

}
