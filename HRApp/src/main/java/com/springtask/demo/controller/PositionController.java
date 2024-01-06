package com.springtask.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtask.demo.binding.Position;
import com.springtask.demo.entities.PositionEntity;
import com.springtask.demo.service.impl.PositionServiceImpl;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
	

	private PositionServiceImpl positionImpl;
	
	public PositionController(PositionServiceImpl positionImpl) {
		this.positionImpl=positionImpl;
	}
	
	@PostMapping("/create")
	public ResponseEntity<PositionEntity> createPosition(@RequestBody PositionEntity position){
		return new ResponseEntity<>(positionImpl.createPosition(position),HttpStatus.CREATED);
	}
	
	@PutMapping("update/{id}")
	public PositionEntity updatePosition(@PathVariable Long id, @RequestBody Position position) {
		return positionImpl.updatePosition(id, position);
	}
	
	@GetMapping("/{id}")
	public PositionEntity fetchPositionById(@PathVariable Long id) {
		return positionImpl.fetchPositionById(id);
	}
	
	@GetMapping("/")
	public List<PositionEntity> fetchPositions(){
		return positionImpl.fetchAllPositions();
	}
	
	@DeleteMapping("/{id}")
	public void deletePositionById(@PathVariable Long id) {
		positionImpl.deletePositionById(id);
	}

}
