package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Requirement;
import com.mx.bbva.business.repository.RequirementRepository;
import com.mx.bbva.business.service.RequirementService;
import com.mx.bbva.util.DateUtils;
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
    public List<Requirement> findByCustomQuery(String query) {
        List<Requirement> requirements = requirementRepository.findByCustomQuery(query);
        for (Requirement requirement : requirements) {
            if (requirement.getBudgetRequirementsList() != null) {
                requirement.setBudgetRequirements(requirement.getBudgetRequirementsList());
            }
        }
        return requirements;
    }

    @Override
    public Requirement saveRequirement(Requirement requirement) {
        requirement.setRequirementDateUpload(new DateUtils().getCurrentDate());
        return requirementRepository.save(requirement);
    }

    @Override
    public Requirement findOneRequirement(Integer requirementId) {
        return requirementRepository.findRequirement(requirementId);
    }

    @Autowired
    public void setRequirementRepository(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }
}
