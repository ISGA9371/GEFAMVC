package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Nature;
import com.mx.bbva.business.service.NatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/natures")
public class NatureController {
    private static final Logger LOG = Logger.getLogger(NatureController.class.getName());

    private NatureService natureService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllNatures() {
        List<Nature> natures = natureService.findAllNatures();
        return new ResponseEntity<Object>(new ResponseListDTO(natures), HttpStatus.OK);
    }

    @Autowired
    public void setNatureService(NatureService natureService) {
        this.natureService = natureService;
    }
}
