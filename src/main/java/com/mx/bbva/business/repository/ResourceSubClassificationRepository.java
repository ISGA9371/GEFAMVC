package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.ResourceSubClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceSubClassificationRepository extends JpaRepository<ResourceSubClassification, Integer> {

}
