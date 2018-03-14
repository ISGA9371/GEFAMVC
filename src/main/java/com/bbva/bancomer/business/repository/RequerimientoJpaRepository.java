package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model._Requerimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("requerimientoJpaRepository")
public interface RequerimientoJpaRepository extends JpaRepository<_Requerimiento, Serializable>{



}
