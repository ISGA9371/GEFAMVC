package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelTypeRepository extends JpaRepository<LevelType, Integer> {
    LevelType findByLevelTypeName(String levelTypeName);
}
