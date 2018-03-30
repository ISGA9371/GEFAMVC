package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.CauseClosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CauseClosureRepository extends JpaRepository<CauseClosure, Integer> {

}
