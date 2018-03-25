package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.LevelType;

import java.util.List;

public interface LevelTypeService {
    List<LevelType> findAllLevelTypes();

    LevelType findByLevelTypeName(String levelTypeName);
}
