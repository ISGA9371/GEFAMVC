package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.ProgramIncrement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramIncrementRepository extends JpaRepository<ProgramIncrement, Integer> {
}
