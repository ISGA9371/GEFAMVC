package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.LevelType;
import com.mx.bbva.business.repository.LevelRepository;
import com.mx.bbva.business.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    private LevelRepository levelRepository;

    @Override
    public List<Level> findAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public List<Level> findByLevelType(LevelType levelType) {
        return levelRepository.findAllByLevelType(levelType);
    }

    @Override
    public List<Level> findByLevelSuperior(Integer levelSuperiorId) {
        return levelRepository.findAllByLevelSuperior(levelSuperiorId);
    }

    @Autowired
    public void setLevelRepository(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
}
