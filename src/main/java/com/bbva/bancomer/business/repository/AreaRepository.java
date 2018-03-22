package com.bbva.bancomer.business.repository;


import com.bbva.bancomer.business.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("areaRepository")
public interface AreaRepository extends JpaRepository<Area, Integer> {

}
