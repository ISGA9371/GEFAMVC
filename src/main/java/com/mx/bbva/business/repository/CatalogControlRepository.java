package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.CatalogControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogControlRepository extends JpaRepository<CatalogControl, Integer> {

}
