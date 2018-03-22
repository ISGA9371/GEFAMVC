package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.repository.LevelRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LevelServiceImpl implements LevelService {

    private LevelRepository levelRepository;

    @Override
    public List<Level> findAllLevels() {
        return (List<Level>) levelRepository.findAll();
    }

    public void setLevelRepository(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }


}
