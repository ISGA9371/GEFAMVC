package com.mx.bbva.business.service;

import com.mx.bbva.business.model.Requirement;

import java.util.List;

public interface RequirementService {
    List<Requirement> findAllRequirements();

    Requirement saveRequirement(Requirement requirement);

    Requirement findOneRequirement(Integer id);
}
