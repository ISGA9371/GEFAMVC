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
    public Level findOneLevel(Integer levelId) {
        return levelRepository.findById(levelId).orElse(null);
    }

    @Override
    public List<Level> findAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public List<Level> findByLevelType(LevelType levelType) {
        return levelRepository.findAllByLevelType(levelType);
    }

    @Override
    public List<Level> findSuperiorLevelsByLevelType(LevelType levelType) {
        return levelRepository.findLevelSuperiorByLevelType(levelType);
    }

    @Override
    public List<Level> findSubLevels(Integer levelId) {
        return levelRepository.findAllByLevelSuperior_LevelId(levelId);
    }

    @Autowired
    public void setLevelRepository(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
}
