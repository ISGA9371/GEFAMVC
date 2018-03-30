package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.OperatingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatingAccountRepository extends JpaRepository<OperatingAccount, Integer> {

}
