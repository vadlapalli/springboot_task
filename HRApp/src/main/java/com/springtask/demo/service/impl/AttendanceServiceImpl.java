package com.springtask.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.springtask.demo.binding.Attendance;
import com.springtask.demo.entities.AttendanceEntity;
import com.springtask.demo.repositories.AttendanceRepository;
import com.springtask.demo.service.AttendanceService;
import com.springtask.demo.service.exceptions.AttedanceNotFoundException;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	private AttendanceRepository attendanceRepo;

	public AttendanceServiceImpl(AttendanceRepository attendanceRepo) {
		super();
		this.attendanceRepo = attendanceRepo;
	}

	@Override
	public AttendanceEntity creatAttendance(Attendance employee) {
		AttendanceEntity entity = new AttendanceEntity();
		BeanUtils.copyProperties(employee, entity);
		return attendanceRepo.save(entity);
	}

	@Override
	public AttendanceEntity updateAttendance(Long id, Attendance employee) {
		Optional<AttendanceEntity> findById = attendanceRepo.findById(id);
		if(findById.isPresent()) {
			 AttendanceEntity attendanceEntity = findById.get();
			BeanUtils.copyProperties(employee, attendanceEntity);
			return attendanceRepo.save(attendanceEntity);
		}else {
			throw new AttedanceNotFoundException("Attendance not found with this id:"+id);
		}
		
	}

	@Override
	public AttendanceEntity fetchAttendanceById(Long id) {
		Optional<AttendanceEntity> findById = attendanceRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			throw new AttedanceNotFoundException("Attendance not found with this id:"+id);
		}
	}

	@Override
	public List<AttendanceEntity> fetchAllAttendances() {
		return attendanceRepo.findAll();
	}

	@Override
	public void deleteAttendanceById(Long id) {
		attendanceRepo.deleteById(id);
		
	}
	
	

}
