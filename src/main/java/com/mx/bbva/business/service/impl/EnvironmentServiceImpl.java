package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Environment;
import com.mx.bbva.business.repository.EnvironmentRepository;
import com.mx.bbva.business.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    private EnvironmentRepository environmentRepository;

    @Override
    public List<Environment> findAllEnvironments() {
        return environmentRepository.findAll();
    }

    @Autowired
    public void setEnvironmentRepository(EnvironmentRepository environmentRepository) {
        this.environmentRepository = environmentRepository;
    }
}
