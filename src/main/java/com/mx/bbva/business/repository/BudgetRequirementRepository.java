package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.BudgetRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRequirementRepository extends JpaRepository<BudgetRequirement, Integer> {

}
