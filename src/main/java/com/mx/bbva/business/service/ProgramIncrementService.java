package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.ProgramIncrement;

import java.util.List;

public interface ProgramIncrementService {
    List<ProgramIncrement> findAll();

    void saveOne(ProgramIncrement programIncrement);

    ProgramIncrement findOne(Integer programIncrementTypeId);
}
