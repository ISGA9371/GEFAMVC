package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Integer> {
    Requirement findByRequirementId(Integer requirementId);
}
