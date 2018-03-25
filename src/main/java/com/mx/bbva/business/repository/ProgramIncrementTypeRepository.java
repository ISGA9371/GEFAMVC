package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.ProgramIncrementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramIncrementTypeRepository extends JpaRepository<ProgramIncrementType, Integer> {
}
