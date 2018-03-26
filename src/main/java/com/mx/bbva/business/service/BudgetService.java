package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Budget;

import java.util.List;

public interface BudgetService {
    void saveBudget(Budget budget);

    Budget findBudget(Integer budgetId);

    List<Budget> findAllBudgets();
}
