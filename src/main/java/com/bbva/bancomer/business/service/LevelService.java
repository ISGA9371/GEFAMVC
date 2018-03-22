package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.model.LevelType;

import java.util.List;

public interface LevelService {
    List<Level> findAllLevels();

    List<Level> findByLevelType(LevelType levelType);
}
