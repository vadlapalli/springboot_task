package com.springtask.demo.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.SalaryCalculation;

public interface SalaryCalculationRepository extends JpaRepository<SalaryCalculation, Long>{

	SalaryCalculation findByCalculationDate(LocalDate lastMonth);

}
