package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Requirement;

import java.util.List;

public interface RequirementService {
    List<Requirement> findAllRequirements();

    List<Requirement> findByCustomQuery(String query);

    Requirement saveRequirement(Requirement requirement);

    Requirement findOneRequirement(Integer id);
}
