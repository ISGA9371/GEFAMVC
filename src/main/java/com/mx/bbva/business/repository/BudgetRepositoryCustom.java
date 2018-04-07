package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Budget;

import java.util.List;

public interface BudgetRepositoryCustom {
    List<Budget> findByCustomQuery(String query);
}
