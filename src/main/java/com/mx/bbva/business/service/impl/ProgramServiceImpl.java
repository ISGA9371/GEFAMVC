package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Program;
import com.mx.bbva.business.repository.ProgramRepository;
import com.mx.bbva.business.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    private ProgramRepository programRepository;

    @Override
    public List<Program> findAllPrograms() {
        return programRepository.findAll();
    }

    @Autowired
    public void setProgramRepository(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }
}
