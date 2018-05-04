package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Methodology;
import com.mx.bbva.business.service.MethodologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/methodologies")
public class MethodologyController {
    private static final Logger LOG = Logger.getLogger(MethodologyController.class.getName());

    private MethodologyService methodologyService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllMethodologies() {
        List<Methodology> methodologies = methodologyService.findAllMethodologies();
        return new ResponseEntity<Object>(new ResponseListDTO(methodologies), HttpStatus.OK);
    }

    @Autowired
    public void setMethodologyService(MethodologyService methodologyService) {
        this.methodologyService = methodologyService;
    }
}
