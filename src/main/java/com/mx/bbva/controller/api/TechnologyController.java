package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Application;
import com.mx.bbva.business.entity.Product;
import com.mx.bbva.business.entity.Technology;
import com.mx.bbva.business.service.ApplicationService;
import com.mx.bbva.business.service.ProductService;
import com.mx.bbva.business.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private static final Logger LOGGER = Logger.getLogger(TechnologyController.class.getName());

    private TechnologyService technologyService;
    private ApplicationService applicationService;
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllTechnologiess() {
        LOGGER.info("find technologies...");
        List<Technology> technologies = technologyService.findAllTechnologies();
        return new ResponseEntity<Object>(new ResponseListDTO(technologies), HttpStatus.OK);
    }

    @RequestMapping(value = "/{technologyId}/applications", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllApplicationsByTech(@PathVariable("technologyId") Integer technologyId) {
        LOGGER.info("find apps by tech..." + technologyId);
        List<Application> applications = applicationService.findAllByTech(technologyId);
        return new ResponseEntity<Object>(new ResponseListDTO(applications), HttpStatus.OK);
    }

    @RequestMapping(value = "/{technologyId}/products", method = RequestMethod.GET, produces = "product/json")
    public ResponseEntity<?> getAllProductsByTech(@PathVariable("technologyId") Integer technologyId) {
        LOGGER.info("find apps by tech..." + technologyId);
        List<Product> products = productService.findAllByTech(technologyId);
        return new ResponseEntity<Object>(new ResponseListDTO(products), HttpStatus.OK);
    }

    @Autowired
    public void setTechnologyService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
