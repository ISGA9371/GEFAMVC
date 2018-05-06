package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.CauseClosure;
import com.mx.bbva.business.service.CauseClosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/cause-closures")
public class CauseClosureController {
    private static final Logger LOG = Logger.getLogger(CauseClosureController.class.getName());

    private CauseClosureService causeClosureService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllCauseClosures() {
        LOG.info("Searching list... CauseClosures");
        List<CauseClosure> causeClosures = causeClosureService.findAllCauseClosures();

        return new ResponseEntity<Object>(new ResponseListDTO(causeClosures), HttpStatus.OK);
    }

    @Autowired
    public void setCauseClosureService(CauseClosureService causeClosureService) {
        this.causeClosureService = causeClosureService;
    }
}
