package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Modification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModificationRepository extends JpaRepository<Modification, Integer> {

}
