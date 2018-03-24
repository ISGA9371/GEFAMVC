package com.mx.bbva.business.service;

import com.mx.bbva.business.model.LevelType;

import java.util.List;

public interface LevelTypeService {
    List<LevelType> findAllLevelTypes();

    LevelType findByLevelTypeName(String levelTypeName);
}
