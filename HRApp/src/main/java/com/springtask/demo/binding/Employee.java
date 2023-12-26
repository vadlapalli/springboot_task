package com.springtask.demo.binding;

import com.springtask.demo.entities.DepartmentEntity;
import com.springtask.demo.entities.PositionEntity;

import lombok.Data;

@Data
public class Employee {
	
	private String name;

    private String email;
    
    private String phoneNumber;

    private String address;
    
    private DepartmentEntity department;
    
    private PositionEntity position;

}
