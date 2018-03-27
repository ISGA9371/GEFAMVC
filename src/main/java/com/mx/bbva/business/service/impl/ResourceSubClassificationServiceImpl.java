package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.ResourceSubClassification;
import com.mx.bbva.business.repository.ResourceSubClassificationRepository;
import com.mx.bbva.business.service.ResourceSubClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceSubClassificationServiceImpl implements ResourceSubClassificationService {
    private ResourceSubClassificationRepository resourceSubClassificationRepository;

    @Override
    public List<ResourceSubClassification> findAllResourceSubClassifications() {
        return resourceSubClassificationRepository.findAll();
    }

    @Autowired
    public void setResourceSubClassificationRepository(ResourceSubClassificationRepository resourceSubClassificationRepository) {
        this.resourceSubClassificationRepository = resourceSubClassificationRepository;
    }
}
