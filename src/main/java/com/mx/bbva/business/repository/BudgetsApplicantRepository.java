package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.BudgetsApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetsApplicantRepository extends JpaRepository<BudgetsApplicant, Integer> {

}
