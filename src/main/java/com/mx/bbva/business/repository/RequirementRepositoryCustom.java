package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Requirement;

import java.util.List;

public interface RequirementRepositoryCustom {
    List<Requirement> findByCustomQuery(String query);
}
