package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.CauseRejection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CauseRejectionRepository extends JpaRepository<CauseRejection, Integer> {

}
