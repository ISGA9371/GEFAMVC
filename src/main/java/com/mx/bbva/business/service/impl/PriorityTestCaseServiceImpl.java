package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.PriorityTestCase;
import com.mx.bbva.business.repository.PriorityTestCaseRepository;
import com.mx.bbva.business.service.PriorityTestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityTestCaseServiceImpl implements PriorityTestCaseService {
    private PriorityTestCaseRepository priorityTestCaseRepository;

    @Override
    public List<PriorityTestCase> findAllPriorityTestCases() {
        return priorityTestCaseRepository.findAll();
    }

    @Autowired
    public void setPriorityTestCaseRepository(PriorityTestCaseRepository priorityTestCaseRepository) {
        this.priorityTestCaseRepository = priorityTestCaseRepository;
    }
}
