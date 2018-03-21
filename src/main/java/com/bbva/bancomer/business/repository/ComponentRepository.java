package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends CrudRepository<Component, Integer> {
}
