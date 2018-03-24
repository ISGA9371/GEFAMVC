package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.ProgramIncrementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramIncrementTypeRepository extends JpaRepository<ProgramIncrementType, Integer> {
}
