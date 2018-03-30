package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Integer>, RequirementRepositoryCustom {
    @Query(value = "SELECT NEW com.mx.bbva.business.entity.Requirement(r.requirementId, r.requirementName) FROM Requirement r")
    Requirement findRequirement(Integer requirementId);
}
