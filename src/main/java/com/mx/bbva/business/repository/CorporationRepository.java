package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporationRepository extends JpaRepository<Corporation, Integer> {

}
