package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByTechnology_TechnologyId(Integer technologyId);
}
