package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.model.LevelType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends CrudRepository<Level, Integer> {
    List<Level> findAllByType(LevelType type);
}
