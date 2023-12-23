package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long>{

}
