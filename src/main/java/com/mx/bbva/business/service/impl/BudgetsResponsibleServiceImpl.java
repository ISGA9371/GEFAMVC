package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.BudgetsResponsible;
import com.mx.bbva.business.repository.BudgetsResponsibleRepository;
import com.mx.bbva.business.service.BudgetsResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetsResponsibleServiceImpl implements BudgetsResponsibleService {
    private BudgetsResponsibleRepository budgetsResponsibleRepository;

    @Override
    public List<BudgetsResponsible> findAllBudgetsResponsible() {
        return budgetsResponsibleRepository.findAll();
    }

    @Autowired
    public void setBudgetsResponsibleRepository(BudgetsResponsibleRepository budgetsResponsibleRepository) {
        this.budgetsResponsibleRepository = budgetsResponsibleRepository;
    }
}
