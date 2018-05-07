package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Result;
import com.mx.bbva.business.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/results")
public class ResultController {
    private static final Logger LOG = Logger.getLogger(ResultController.class.getName());

    private ResultService resultService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllResults() {
        LOG.info("Searching list... Result");
        List<Result> results = resultService.findAllResults();

        return new ResponseEntity<Object>(new ResponseListDTO(results), HttpStatus.OK);
    }

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }
}
