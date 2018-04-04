package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.ProgramIncrement;
import com.mx.bbva.business.entity.Project;

import java.util.List;

public interface ProgramIncrementService {
    List<ProgramIncrement> findAll();

    void saveOne(ProgramIncrement programIncrement);

    ProgramIncrement findOne(Integer programIncrementTypeId);

    List<Project> findProjectsByPI(Integer programIncrementId);
}
