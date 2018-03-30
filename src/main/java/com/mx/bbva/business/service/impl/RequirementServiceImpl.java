package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Requirement;
import com.mx.bbva.business.repository.RequirementRepository;
import com.mx.bbva.business.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImpl implements RequirementService {
    private RequirementRepository requirementRepository;

    @Override
    public List<Requirement> findAllRequirements() {
        return requirementRepository.findAll();
    }

    @Override
    public Requirement saveRequirement(Requirement requirement) {
        return requirementRepository.save(requirement);
    }

    @Override
    public Requirement findOne(Integer requirementId) {
        return requirementRepository.findRequirement(requirementId);
    }

    @Autowired
    public void setRequirementRepository(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }
}
