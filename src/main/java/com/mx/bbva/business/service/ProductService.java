package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    List<Product> findAllByTech(Integer technologyId);
}
