package com.bbva.bancomer.business.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequerimientoJpaRepository extends CrudRepository<Requerimiento, Integer> {

}
