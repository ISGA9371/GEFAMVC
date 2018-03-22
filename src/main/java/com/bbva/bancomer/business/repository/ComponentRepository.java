package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Component;
import com.bbva.bancomer.business.model.Component_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Integer> {
    Component_ findByComponentVersion(String componentVersion);
}
