package com.springtask.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.springtask.demo.binding.Position;
import com.springtask.demo.entities.PositionEntity;
import com.springtask.demo.repositories.PositionRepository;
import com.springtask.demo.service.PositionService;

@Service

public class PositionServiceImpl implements PositionService {
	
	private PositionRepository positionRepo;
	
	public PositionServiceImpl(PositionRepository positionRepo) {
		super();
		this.positionRepo = positionRepo;
	}

	@Override
	public PositionEntity createPosition(PositionEntity position) {
		return positionRepo.save(position);
	}

	@Override
	public PositionEntity updatePosition(Long id, Position position) {
		Optional<PositionEntity> findById = positionRepo.findById(id);
		if(findById.isPresent()) {
			PositionEntity positionEntity = findById.get();
			BeanUtils.copyProperties(position, positionEntity);
			return positionRepo.save(positionEntity);
		}
		return null;
	}

	@Override
	public PositionEntity fetchPositionById(Long id) {
		Optional<PositionEntity> findById = positionRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<PositionEntity> fetchAllPositions() {
		return positionRepo.findAll();
	}

	@Override
	public void deletePositionById(Long id) {
		positionRepo.deleteById(id);
		
	}
	
	

}
