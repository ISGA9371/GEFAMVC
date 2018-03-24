package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.ProgramIncrementType;

import java.util.List;

public interface ProgramIncrementTypeService {
    List<ProgramIncrementType> findAll();

    void saveOne(ProgramIncrementType programIncrementType);

    ProgramIncrementType findOne(Integer programIncrementTypeId);
}
