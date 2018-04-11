package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Technology;
import com.mx.bbva.business.service.TechnologyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/technologies")
public class TechnologyController {
    private static final Logger LOGGER = Logger.getLogger(TechnologyController.class.getName());
    private TechnologyService technologyService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllTechnologiess() {
        LOGGER.info("find technologies...");
        List<Technology> technologies = technologyService.findAllTechnologies();
        return new ResponseEntity<Object>(new ResponseListDTO(technologies), HttpStatus.OK);
    }

}
