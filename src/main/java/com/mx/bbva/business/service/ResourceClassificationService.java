package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.ResourceClassification;
import com.mx.bbva.business.entity.ResourceSubClassification;

import java.util.List;

public interface ResourceClassificationService {
    List<ResourceClassification> findAllResourceClassifications();

    List<ResourceSubClassification> findAllSubClassifications(Integer resourceClassificationId);

    ResourceClassification findResourceClassification(Integer resourceClassificationId);
}
