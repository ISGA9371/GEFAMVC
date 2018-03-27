package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.ResourceClassification;
import com.mx.bbva.business.repository.ResourceClassificationRepository;
import com.mx.bbva.business.service.ResourceClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceClassificationServiceImpl implements ResourceClassificationService {
    private ResourceClassificationRepository resourceClassificationRepository;

    @Override
    public List<ResourceClassification> findAllResourceClassifications() {
        return resourceClassificationRepository.findAll();
    }

    @Autowired
    public void setResourceClassificationRepository(ResourceClassificationRepository resourceClassificationRepository) {
        this.resourceClassificationRepository = resourceClassificationRepository;
    }
}
