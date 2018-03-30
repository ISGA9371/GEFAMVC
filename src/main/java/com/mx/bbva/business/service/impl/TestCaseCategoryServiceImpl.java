package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.TestCaseCategory;
import com.mx.bbva.business.repository.TestCaseCategoryRepository;
import com.mx.bbva.business.service.TestCaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseCategoryServiceImpl implements TestCaseCategoryService {
    private TestCaseCategoryRepository testCaseCategoryRepository;

    @Override
    public List<TestCaseCategory> findAllTestCaseCategories() {
        return testCaseCategoryRepository.findAll();
    }

    @Autowired
    public void setTestCaseCategoryRepository(TestCaseCategoryRepository testCaseCategoryRepository) {
        this.testCaseCategoryRepository = testCaseCategoryRepository;
    }
}
