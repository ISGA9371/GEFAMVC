package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.DoubtType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoubtTypeRepository extends JpaRepository<DoubtType, Integer> {

}
