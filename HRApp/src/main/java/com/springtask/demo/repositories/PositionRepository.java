package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, Long>{

}
