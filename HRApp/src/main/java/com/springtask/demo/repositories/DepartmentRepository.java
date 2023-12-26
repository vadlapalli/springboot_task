package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{

}
