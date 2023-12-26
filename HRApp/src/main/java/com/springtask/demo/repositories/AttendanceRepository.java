package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.AttendanceEntity;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long>{

}
