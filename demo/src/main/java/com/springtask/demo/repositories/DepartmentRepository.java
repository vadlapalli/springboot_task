package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
