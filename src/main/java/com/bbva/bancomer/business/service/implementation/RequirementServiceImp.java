package com.bbva.bancomer.business.service.implementation;

import com.bbva.bancomer.business.model.Requirement;
import com.bbva.bancomer.business.repository.RequirementRepository;
import com.bbva.bancomer.business.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImp implements RequirementService {
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
    public Requirement findOneRequirement(Integer requirementId) {
        return requirementRepository.findById(requirementId).orElse(null);
    }

    @Autowired
    public void setRequirementRepository(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }
}
