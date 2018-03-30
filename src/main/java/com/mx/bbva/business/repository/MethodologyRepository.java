package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Methodology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodologyRepository extends JpaRepository<Methodology, Integer> {
}
