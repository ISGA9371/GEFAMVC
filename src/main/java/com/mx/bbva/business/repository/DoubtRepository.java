package com.mx.bbva.business.repository;


import com.mx.bbva.business.model.Doubt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoubtRepository extends JpaRepository<Doubt, Integer> {

}
