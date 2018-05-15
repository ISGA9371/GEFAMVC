package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.BudgetsApplicant;
import com.mx.bbva.business.repository.BudgetsApplicantRepository;
import com.mx.bbva.business.service.BudgetsApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetsApplicantServiceImpl implements BudgetsApplicantService {
    private BudgetsApplicantRepository budgetsApplicantRepository;

    @Override
    public List<BudgetsApplicant> findAllBudgetsApplicants() {
        return budgetsApplicantRepository.findAll();
    }

    @Autowired
    public void setBudgetsApplicantRepository(BudgetsApplicantRepository budgetsApplicantRepository) {
        this.budgetsApplicantRepository = budgetsApplicantRepository;
    }
}
