package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Banking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository extends JpaRepository<Banking, Integer> {

}
