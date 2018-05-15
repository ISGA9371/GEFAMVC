package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.entity.BudgetRequirement;

import java.util.List;

public interface BudgetService {
    void saveBudget(Budget budget);

    Budget findBudget(String budgetId);

    List<Budget> findAllBudgets();

    List<Budget> findByCustomQuery(String query);

    List<Integer> findAllYears();

    void assignBudget(List<BudgetRequirement> budgetRequirements);

    boolean notAvailableForAssignment(BudgetRequirement budgetRequirement);
}
