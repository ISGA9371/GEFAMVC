package com.bbva.bancomer.business.repository;

import com.bbva.bancomer.business.model._Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<_Cliente, Integer> {


}
