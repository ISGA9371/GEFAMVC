package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.VerificationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationResultRepository extends JpaRepository<VerificationResult, Integer> {

}
