package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.SalaryEntity;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long>{

}
