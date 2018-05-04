package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Fare;
import com.mx.bbva.business.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/fares")
public class FareController {
    private static final Logger LOG = Logger.getLogger(FareController.class.getName());

    private FareService fareService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllFares() {
        List<Fare> fares = fareService.findAllFares();
        return new ResponseEntity<Object>(new ResponseListDTO(fares), HttpStatus.OK);
    }

    @Autowired
    public void setFareService(FareService fareService) {
        this.fareService = fareService;
    }
}
