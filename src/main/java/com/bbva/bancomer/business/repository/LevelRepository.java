package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Level;
import com.bbva.bancomer.business.model.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    @Transactional
    List<Level> findAllByLevelType(LevelType levelType);

    @Transactional
    List<Level> findAllByLevelSuperior(Level LevelSuperior);

}
