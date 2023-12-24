package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.SalaryCalculation;

public interface SalaryCalculationRepository extends JpaRepository<SalaryCalculation, Long>{

}
