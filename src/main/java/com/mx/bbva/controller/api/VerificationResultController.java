package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.VerificationResult;
import com.mx.bbva.business.service.VerificationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/verification-results")
public class VerificationResultController {
    private static final Logger LOG = Logger.getLogger(VerificationResultController.class.getName());

    private VerificationResultService verificationResultService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllVerificationResults() {
        LOG.info("Searching list... VerificationResults");
        List<VerificationResult> verificationResults = verificationResultService.findAllVerificationResults();

        return new ResponseEntity<Object>(new ResponseListDTO(verificationResults), HttpStatus.OK);
    }

    @Autowired
    public void setVerificationResultService(VerificationResultService verificationResultService) {
        this.verificationResultService = verificationResultService;
    }
}
