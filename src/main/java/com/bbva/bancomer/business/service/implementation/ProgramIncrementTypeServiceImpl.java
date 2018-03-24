package com.bbva.bancomer.business.service.implementation;

import com.bbva.bancomer.business.model.ProgramIncrementType;
import com.bbva.bancomer.business.repository.ProgramIncrementTypeRepository;
import com.bbva.bancomer.business.service.ProgramIncrementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramIncrementTypeServiceImpl implements ProgramIncrementTypeService {
    private ProgramIncrementTypeRepository repository;

    @Override
    public List<ProgramIncrementType> findAll() {
        return repository.findAll();
    }

    @Override
    public void saveOne(ProgramIncrementType programIncrementType) {
        repository.save(programIncrementType);
    }

    @Override
    public ProgramIncrementType findOne(Integer programIncrementTypeId) {
        return repository.findById(programIncrementTypeId).orElse(null);
    }

    @Autowired
    public void setRepository(ProgramIncrementTypeRepository repository) {
        this.repository = repository;
    }
}
