package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTypeRepository extends JpaRepository<StatusType, Integer> {

}
