package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.ProgramIncrement;
import com.mx.bbva.business.repository.ProgramIncrementRepository;
import com.mx.bbva.business.service.ProgramIncrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramIncrementServiceImpl implements ProgramIncrementService {
    private ProgramIncrementRepository repository;

    @Override
    public List<ProgramIncrement> findAll() {
        return repository.findAll();
    }

    @Override
    public void saveOne(ProgramIncrement programIncrement) {
        repository.save(programIncrement);
    }

    @Override
    public ProgramIncrement findOne(Integer programIncrementId) {
        return repository.findById(programIncrementId).orElse(null);
    }

    @Autowired
    public void setRepository(ProgramIncrementRepository repository) {
        this.repository = repository;
    }
}
