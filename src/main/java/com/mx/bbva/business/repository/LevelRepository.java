package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    @Transactional
    List<Level> findAllByLevelType(LevelType levelType);

    @Query(value = "SELECT * FROM gestion_factoria.thge010_nivel where cd_nivel_superior = ?1",
    nativeQuery = true)
    @Transactional
    List<Level> findAllByLevelSuperior(Integer levelSuperiorId);

}
