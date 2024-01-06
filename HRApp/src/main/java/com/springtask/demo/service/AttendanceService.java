package com.springtask.demo.service;

import java.util.List;

import com.springtask.demo.binding.Attendance;
import com.springtask.demo.entities.AttendanceEntity;


public interface AttendanceService {
	
public AttendanceEntity creatAttendance(Attendance employee);
	
	public AttendanceEntity updateAttendance(Long id,Attendance employee);
	
	public AttendanceEntity fetchAttendanceById(Long id);
	
	public List<AttendanceEntity> fetchAllAttendances();
	
	public void deleteAttendanceById(Long id);

}
