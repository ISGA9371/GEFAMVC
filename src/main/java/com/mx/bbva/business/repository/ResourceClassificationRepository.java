package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.ResourceClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceClassificationRepository extends JpaRepository<ResourceClassification, Integer> {

}
