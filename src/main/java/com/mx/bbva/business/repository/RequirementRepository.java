package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Integer>, RequirementRepositoryCustom {
    @Query(value = "FROM Requirement r WHERE r.requirementId = :requirementId ")
    Requirement findRequirement(@Param(value = "requirementId") Integer requirementId);
}
