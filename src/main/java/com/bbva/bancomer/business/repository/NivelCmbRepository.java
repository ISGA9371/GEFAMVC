package com.bbva.bancomer.business.repository;


import com.bbva.bancomer.business.model.NivelCmb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("nivelCmbRepository")
public interface NivelCmbRepository extends JpaRepository<NivelCmb,Serializable> {


}
