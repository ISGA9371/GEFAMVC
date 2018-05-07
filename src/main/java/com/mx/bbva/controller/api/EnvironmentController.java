package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Environment;
import com.mx.bbva.business.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/environments")
public class EnvironmentController {
    private static final Logger LOG = Logger.getLogger(EnvironmentController.class.getName());

    private EnvironmentService environmentService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllEnvironments() {
        LOG.info("Searching list... Environments");
        List<Environment> environments = environmentService.findAllEnvironments();

        return new ResponseEntity<Object>(new ResponseListDTO(environments), HttpStatus.OK);
    }

    @Autowired
    public void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }
}
