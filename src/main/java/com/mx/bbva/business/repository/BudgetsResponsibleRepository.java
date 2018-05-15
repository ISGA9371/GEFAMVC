package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.BudgetsResponsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetsResponsibleRepository extends JpaRepository<BudgetsResponsible, Integer> {

}
