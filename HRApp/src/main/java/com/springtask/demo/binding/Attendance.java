package com.springtask.demo.binding;

import java.time.LocalDateTime;

import com.springtask.demo.entities.EmployeeEntity;

import lombok.Data;

@Data
public class Attendance {
	
	 private LocalDateTime inTime;
	 
	 private LocalDateTime outTime;
	 
	 private EmployeeEntity employee;

}
