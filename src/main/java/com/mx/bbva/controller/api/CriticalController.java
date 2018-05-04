package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Critical;
import com.mx.bbva.business.service.CriticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/criticals")
public class CriticalController {
    private static final Logger LOG = Logger.getLogger(CriticalController.class.getName());

    private CriticalService criticalService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllCriticals() {
        List<Critical> criticals = criticalService.findAllCriticals();
        return new ResponseEntity<Object>(new ResponseListDTO(criticals), HttpStatus.OK);
    }

    @Autowired
    public void setCriticalService(CriticalService criticalService) {
        this.criticalService = criticalService;
    }
}
