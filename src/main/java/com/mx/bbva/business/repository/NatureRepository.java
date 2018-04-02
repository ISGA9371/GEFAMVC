package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Nature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureRepository extends JpaRepository<Nature, Integer> {

}
