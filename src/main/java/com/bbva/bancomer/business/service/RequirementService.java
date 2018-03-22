package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Requirement;

import java.util.List;

public interface RequirementService {
    List<Requirement> findAllRequirements();

    Requirement saveRequirement(Requirement requirement);

    Requirement findOneRequirement(Integer id);
}
