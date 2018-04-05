package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.repository.BudgetRepository;
import com.mx.bbva.business.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    private BudgetRepository budgetRepository;

    @Override
    public void saveBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    @Override
    public Budget findBudget(String budgetId) {
        return budgetRepository.findById(budgetId).orElse(null);
    }

    @Override
    public List<Budget> findAllBudgets() {
        return budgetRepository.findAll();
    }

    @Autowired
    public void setBudgetRepository(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }
}
