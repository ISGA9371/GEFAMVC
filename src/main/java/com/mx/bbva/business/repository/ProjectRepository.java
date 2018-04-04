package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByProgramIncrement_programIncrementId(Integer programIncrementId);
}
