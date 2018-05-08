package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.ResourceClassification;
import com.mx.bbva.business.entity.ResourceSubClassification;
import com.mx.bbva.business.repository.ResourceClassificationRepository;
import com.mx.bbva.business.repository.ResourceSubClassificationRepository;
import com.mx.bbva.business.service.ResourceClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceClassificationServiceImpl implements ResourceClassificationService {
    private ResourceClassificationRepository resourceClassificationRepository;
    private ResourceSubClassificationRepository subClassificationRepository;

    @Override
    public List<ResourceClassification> findAllResourceClassifications() {
        return resourceClassificationRepository.findAll();
    }

    @Override
    public List<ResourceSubClassification> findAllSubClassifications(Integer resourceClassificationId) {
        return subClassificationRepository.findByResourceClassification(new ResourceClassification(resourceClassificationId));
    }

    @Override
    public ResourceClassification findResourceClassification(Integer resourceClassificationId) {
        return resourceClassificationRepository.findById(resourceClassificationId).orElse(null);
    }

    @Autowired
    public void setResourceClassificationRepository(ResourceClassificationRepository resourceClassificationRepository) {
        this.resourceClassificationRepository = resourceClassificationRepository;
    }

    @Autowired
    public void setSubClassificationRepository(ResourceSubClassificationRepository subClassificationRepository) {
        this.subClassificationRepository = subClassificationRepository;
    }
}
