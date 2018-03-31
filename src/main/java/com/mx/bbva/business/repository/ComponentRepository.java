package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Integer>, ComponentRepositoryCustom {

}
