package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.CauseRejection;
import com.mx.bbva.business.service.CauseRejectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/cause-rejections")
public class CauseRejectionController {
    private static final Logger LOG = Logger.getLogger(CauseRejectionController.class.getName());

    private CauseRejectionService causeRejectionService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllCauseRejections() {
        LOG.info("Searching list... CauseRejections");
        List<CauseRejection> causeRejections = causeRejectionService.findAllCauseRejections();

        return new ResponseEntity<Object>(new ResponseListDTO(causeRejections), HttpStatus.OK);
    }

    @Autowired
    public void setCauseRejectionService(CauseRejectionService causeRejectionService) {
        this.causeRejectionService = causeRejectionService;
    }
}
