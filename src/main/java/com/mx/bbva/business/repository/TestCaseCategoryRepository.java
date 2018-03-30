package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.TestCaseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseCategoryRepository extends JpaRepository<TestCaseCategory, Integer> {

}
