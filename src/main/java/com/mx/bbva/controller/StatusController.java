package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Status;
import com.mx.bbva.business.entity.StatusType;
import com.mx.bbva.business.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/status")
public class StatusController {
    private static final Logger LOGGER = Logger.getLogger(StatusController.class.getName());

    private StatusService statusService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllStatus() {
        LOGGER.info("find status...");
        List<Status> statusList = statusService.findAllStatus();
        return new ResponseEntity<Object>(new ResponseListDTO(statusList), HttpStatus.OK);
    }

    @RequestMapping(value = "/types/{statusTypeId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllStatusByType(@PathVariable(name = "statusTypeId", required = false) Integer statusTypeId) {
        LOGGER.info("find status by type...");
        List<Status> statusList = statusService.findStatusByType(new StatusType(statusTypeId));
        return new ResponseEntity<Object>(new ResponseListDTO(statusList), HttpStatus.OK);
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }
}
