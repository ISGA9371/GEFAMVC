package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, String>, BudgetRepositoryCustom {

    @Query(value = "SELECT b.budgetYear FROM Budget b")
    List<Integer> findBudgetYear();
}
