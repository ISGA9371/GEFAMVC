package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Requerimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequerimientoJpaRepository extends CrudRepository<Requerimiento, Integer> {

}
