package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.LevelType;

import java.util.List;

public interface LevelService {
    Level findOneLevel(Integer levelId);

    List<Level> findAllLevels();

    List<Level> findByLevelType(LevelType levelType);

    List<Level> findSuperiorLevelsByLevelType(LevelType levelType);

    List<Level> findSubLevels(Integer levelId);
}
