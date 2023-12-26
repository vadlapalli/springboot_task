package com.springtask.demo.service;

import java.util.List;

import com.springtask.demo.binding.Position;
import com.springtask.demo.entities.PositionEntity;

public interface PositionService {
	
	public PositionEntity createPosition(PositionEntity position);
	
	public PositionEntity updatePosition(Long id,Position position);
	
	public PositionEntity fetchPositionById(Long id);
	
	public List<PositionEntity> fetchAllPositions();
	
	public void deletePositionById(Long id);
		

}
