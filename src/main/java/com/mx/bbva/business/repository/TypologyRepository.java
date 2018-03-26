package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Typology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypologyRepository extends JpaRepository<Typology, Integer>{
   List<Typology> findAllByTypologyComponent(String arg);
}
