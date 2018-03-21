package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Technology;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends CrudRepository<Technology, Integer> {

}
