package com.bbva.bancomer.business.service.implementation;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.model.LevelType;
import com.bbva.bancomer.business.repository.LevelRepository;
import com.bbva.bancomer.business.service.LevelService;
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

    @Autowired
    public void setLevelRepository(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
}
