package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.model.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelTypeRepository extends JpaRepository<LevelType, Integer> {
    LevelType findByLevelTypeName(String nombre);
}
