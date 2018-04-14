package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Typology;
import com.mx.bbva.business.service.TypologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/typologies")
public class TypologyController {
    private static final Logger LOGGER = Logger.getLogger(TypologyController.class.getName());

    private TypologyService typologyService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllTypologies() {
        LOGGER.info("find typologies...");
        List<Typology> typologies = typologyService.findAllTypologies();
        return new ResponseEntity<Object>(new ResponseListDTO(typologies), HttpStatus.OK);
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllTypologiesByType(@RequestParam(value = "componentModified", required = false) Boolean componentModified) {
        LOGGER.info("find typologies...");
        List<Typology> typologies = typologyService.findByComponent(componentModified);
        return new ResponseEntity<Object>(new ResponseListDTO(typologies), HttpStatus.OK);
    }


    @Autowired
    public void setTypologyService(TypologyService typologyService) {
        this.typologyService = typologyService;
    }

}
