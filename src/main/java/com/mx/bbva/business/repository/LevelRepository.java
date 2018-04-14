package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    @Transactional
    List<Level> findAllByLevelType(LevelType levelType);

    List<Level> findLevelSuperiorByLevelType(LevelType levelType);

    List<Level> findAllByLevelSuperior_LevelId(Integer levelId);
}
