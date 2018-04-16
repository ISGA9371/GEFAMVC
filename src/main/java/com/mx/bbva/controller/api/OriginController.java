package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Origin;
import com.mx.bbva.business.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/origins")
public class OriginController {
    private static final Logger LOG = Logger.getLogger(OriginController.class.getName());

    private OriginService originService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllOrigins() {
        List<Origin> origins = originService.findAllOrigins();
        return new ResponseEntity<Object>(new ResponseListDTO(origins), HttpStatus.OK);
    }

    @Autowired
    public void setOriginService(OriginService originService) {
        this.originService = originService;
    }
}
