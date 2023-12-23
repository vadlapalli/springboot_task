package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
