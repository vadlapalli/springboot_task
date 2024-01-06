package com.springtask.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtask.demo.binding.Attendance;
import com.springtask.demo.entities.AttendanceEntity;
import com.springtask.demo.service.impl.AttendanceServiceImpl;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
	
	
	private AttendanceServiceImpl serviceImpl;
	
	
	public AttendanceController(AttendanceServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}


	@PostMapping("/create")
	public AttendanceEntity postAttedance(@RequestBody Attendance attendance) {
		return serviceImpl.creatAttendance(attendance);
	}
	
	
	@PutMapping("update/{id}")
	public AttendanceEntity updateAttendance(@PathVariable Long id,@RequestBody Attendance attendance) {
		return serviceImpl.updateAttendance(id, attendance);
	}
	
	@GetMapping("/{id}")
	public AttendanceEntity fetchAttenndanceById(@PathVariable Long id) {
		return serviceImpl.fetchAttendanceById(id);
	}
	
	@GetMapping("/")
	public List<AttendanceEntity> fetchAllAttendance(){
		return serviceImpl.fetchAllAttendances();
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteAttendanceById(@PathVariable Long id) {
		serviceImpl.deleteAttendanceById(id);
	}

}
