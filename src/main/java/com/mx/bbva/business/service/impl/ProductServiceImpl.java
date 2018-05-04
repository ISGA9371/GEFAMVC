package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Product;
import com.mx.bbva.business.repository.ProductRepository;
import com.mx.bbva.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByTech(Integer technologyId) {
        return productRepository.findByTechnology_TechnologyId(technologyId);
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
