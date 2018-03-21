package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model.Tecnologia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiaRepository extends CrudRepository<Tecnologia, Integer> {

}
