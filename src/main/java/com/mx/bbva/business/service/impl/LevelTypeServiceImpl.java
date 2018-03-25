package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.LevelType;
import com.mx.bbva.business.repository.LevelTypeRepository;
import com.mx.bbva.business.service.LevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelTypeServiceImpl implements LevelTypeService {
    private LevelTypeRepository levelTypeRepository;

    @Override
    public List<LevelType> findAllLevelTypes() {
        return levelTypeRepository.findAll();
    }

    @Override
    public LevelType findByLevelTypeName(String levelTypeName) {
        return levelTypeRepository.findByLevelTypeName(levelTypeName);
    }

    @Autowired
    public void setLevelTypeRepository(LevelTypeRepository levelTypeRepository) {
        this.levelTypeRepository = levelTypeRepository;
    }
}
