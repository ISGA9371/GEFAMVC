package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.ProgramIncrementType;

import java.util.List;

public interface ProgramIncrementTypeService {
    List<ProgramIncrementType> findAll();

    void saveOne(ProgramIncrementType programIncrementType);

    ProgramIncrementType findOne(Integer programIncrementTypeId);
}
