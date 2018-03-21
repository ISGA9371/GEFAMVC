package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbva.bancomer.business.service.LevelService;

import java.util.List;

public class LevelServiceImpl implements LevelService {

    @Autowired private LevelRepository levelRepository;

    @Override
    public List<Level> findAllLevels() {
        return levelRepository.findAll();
    }

    public void setLevelRepository(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }
}
