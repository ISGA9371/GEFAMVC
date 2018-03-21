package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Level_;
import com.bbva.bancomer.business.repository.LevelRepository_;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LevelServiceImpl_ implements LevelService_ {

    @Autowired private LevelRepository_ levelRepository;

    @Override
    public List<Level_> findAllLevels() {
        return levelRepository.findAll();
    }

    public void setLevelRepository(LevelRepository_ levelRepository) {
        this.levelRepository = levelRepository;
    }
}
