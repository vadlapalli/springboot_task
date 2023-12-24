package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.Position;

public interface PositionRepository extends JpaRepository<Position, Long>{

}