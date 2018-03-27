package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.AssignationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignationTypeRepository extends JpaRepository<AssignationType, Integer> {

}
