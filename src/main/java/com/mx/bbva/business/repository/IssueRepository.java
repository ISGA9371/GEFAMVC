package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

    boolean existsByComponent_ComponentId(Integer componentId);
}
