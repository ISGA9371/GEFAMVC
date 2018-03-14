package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Requerimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
public interface RequerimientoJpaRepository extends CrudRepository<Requerimiento, Integer> {

}
