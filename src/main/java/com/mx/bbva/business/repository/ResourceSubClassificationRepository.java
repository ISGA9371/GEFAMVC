package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.ResourceClassification;
import com.mx.bbva.business.entity.ResourceSubClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceSubClassificationRepository extends JpaRepository<ResourceSubClassification, Integer> {

    List<ResourceSubClassification> findByResourceClassification(ResourceClassification resourceClassification);
}
