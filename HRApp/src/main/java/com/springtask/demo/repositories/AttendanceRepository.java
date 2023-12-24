package com.springtask.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtask.demo.entities.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

}
