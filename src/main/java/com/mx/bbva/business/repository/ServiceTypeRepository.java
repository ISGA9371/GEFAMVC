package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Area;
import com.mx.bbva.business.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {

    List<ServiceType> findByArea(Area area);

}
