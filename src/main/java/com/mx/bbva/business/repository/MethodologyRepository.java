package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Methodology;
import com.mx.bbva.business.entity.Modification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MethodologyRepository extends JpaRepository<Methodology, Integer> {
}
