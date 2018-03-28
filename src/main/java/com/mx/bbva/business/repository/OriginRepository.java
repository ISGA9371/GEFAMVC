package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Integer> {

}
