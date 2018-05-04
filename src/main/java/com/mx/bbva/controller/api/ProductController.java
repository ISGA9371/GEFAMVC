package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Product;
import com.mx.bbva.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    private static final Logger LOG = Logger.getLogger(ProductController.class.getName());

    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<Object>(new ResponseListDTO(products), HttpStatus.OK);
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
