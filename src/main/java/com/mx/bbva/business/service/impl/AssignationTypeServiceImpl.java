package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.AssignationType;
import com.mx.bbva.business.repository.AssignationTypeRepository;
import com.mx.bbva.business.service.AssignationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignationTypeServiceImpl implements AssignationTypeService {
    private AssignationTypeRepository assignationTypeRepository;

    @Override
    public List<AssignationType> findAllAssignationTypes() {
        return assignationTypeRepository.findAll();
    }

    @Autowired
    public void setAssignationTypeRepository(AssignationTypeRepository assignationTypeRepository) {
        this.assignationTypeRepository = assignationTypeRepository;
    }
}
