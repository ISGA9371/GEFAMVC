package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.entity.BudgetRequirement;
import com.mx.bbva.business.repository.BudgetRepository;
import com.mx.bbva.business.repository.BudgetRequirementRepository;
import com.mx.bbva.business.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    private BudgetRepository budgetRepository;
    private BudgetRequirementRepository budgetRequirementRepository;

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

    @Override
    public List<Budget> findByCustomQuery(String query) {
        return budgetRepository.findByCustomQuery(query);
    }

    @Override
    public List<Integer> findAllYears() {
        return budgetRepository.findBudgetYear();
    }

    @Override
    public void assignBudget(List<BudgetRequirement> budgetRequirements) {
        budgetRequirementRepository.saveAll(budgetRequirements);
    }

    @Autowired
    public void setBudgetRepository(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @Autowired
    public void setBudgetRequirementRepository(BudgetRequirementRepository budgetRequirementRepository) {
        this.budgetRequirementRepository = budgetRequirementRepository;
    }
}
