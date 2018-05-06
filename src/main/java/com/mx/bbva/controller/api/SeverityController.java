package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Severity;
import com.mx.bbva.business.service.SeverityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/severities")
public class SeverityController {
    private static final Logger LOG = Logger.getLogger(SeverityController.class.getName());

    private SeverityService severityService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllSeverities() {
        LOG.info("Searching list... Severities");
        List<Severity> severities = severityService.findAllSeverities();

        return new ResponseEntity<Object>(new ResponseListDTO(severities), HttpStatus.OK);
    }

    @Autowired
    public void setSeverityService(SeverityService severityService) {
        this.severityService = severityService;
    }
}
