package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("technologyRepository")
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
