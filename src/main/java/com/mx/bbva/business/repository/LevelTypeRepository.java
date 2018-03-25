package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelTypeRepository extends JpaRepository<LevelType, Integer> {
    LevelType findByLevelTypeName(String levelTypeName);
}
