package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Application;
import com.mx.bbva.business.entity.Technology;
import com.mx.bbva.business.repository.ApplicationRepository;
import com.mx.bbva.business.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> findAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Application> findAllByTech(Integer technologyId) {
        return applicationRepository.findByTechnology(new Technology(technologyId));
    }

    @Autowired
    public void setApplicationRepository(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
}
