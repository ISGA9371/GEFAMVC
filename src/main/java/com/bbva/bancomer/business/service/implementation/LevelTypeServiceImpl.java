package com.bbva.bancomer.business.service.implementation;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.model.LevelType;
import com.bbva.bancomer.business.repository.LevelTypeRepository;
import com.bbva.bancomer.business.service.LevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
