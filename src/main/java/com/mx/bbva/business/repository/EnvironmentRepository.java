package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Integer> {

}
