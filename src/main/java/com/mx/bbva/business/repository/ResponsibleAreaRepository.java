package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.ResponsibleArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleAreaRepository extends JpaRepository<ResponsibleArea, Integer> {

}
