package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.model.Level_;
import com.bbva.bancomer.business.repository.LevelRepository_;
import org.springframework.beans.factory.annotation.Autowired;
import com.bbva.bancomer.business.service.LevelService_;

import java.util.List;

public class LevelServiceImpl implements LevelService_ {

    @Autowired private LevelRepository_ levelRepository;

    @Override
    public List<Level_> findAllLevels() {
        return levelRepository.findAll();
    }

    public void setLevelRepository(LevelRepository_ levelRepository) {
        this.levelRepository = levelRepository;
    }
}
