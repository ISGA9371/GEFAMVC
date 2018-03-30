package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeverityRepository extends JpaRepository<Severity, Integer> {

}
