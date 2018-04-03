package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.PriorityTestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityTestCaseRepository extends JpaRepository<PriorityTestCase, Integer> {

}
