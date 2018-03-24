package com.mx.bbva.business.service;

import com.mx.bbva.business.model.Level;
import com.mx.bbva.business.model.LevelType;

import java.util.List;

public interface LevelService {
    List<Level> findAllLevels();

    List<Level> findByLevelType(LevelType levelType);
}
