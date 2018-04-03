package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Severity;
import com.mx.bbva.business.repository.SeverityRepository;
import com.mx.bbva.business.service.SeverityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeverityServiceImpl implements SeverityService {
    private SeverityRepository severityRepository;

    @Override
    public List<Severity> findAllSeverities() {
        return severityRepository.findAll();
    }

    @Autowired
    public void setSeverityRepository(SeverityRepository severityRepository) {
        this.severityRepository = severityRepository;
    }
}
