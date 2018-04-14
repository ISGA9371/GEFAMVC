package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Status;
import com.mx.bbva.business.entity.StatusType;
import com.mx.bbva.business.service.StatusService;
import com.mx.bbva.business.service.StatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/status-types")
public class StatusTypesController {
    private static final Logger LOGGER = Logger.getLogger(StatusTypesController.class.getName());

    private StatusService statusService;
    private StatusTypeService statusTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllStatus() {
        LOGGER.info("find status...");
        List<StatusType> statusList = statusTypeService.findAllStatusTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(statusList), HttpStatus.OK);
    }

    @RequestMapping(value = "/{statusTypeId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getStatusType(@PathVariable(name = "statusTypeId") Integer statusTypeId) {
        LOGGER.info("find status..." + statusTypeId);
        StatusType status = statusTypeService.findOneStatusType(statusTypeId);
        return new ResponseEntity<Object>(new ResponseDTO(status), HttpStatus.OK);
    }

    @RequestMapping(value = "/{statusTypeId}/status", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllStatusByType(@PathVariable(name = "statusTypeId") Integer statusTypeId) {
        LOGGER.info("find status by type..." + statusTypeId);
        List<Status> statusList = statusService.findStatusByType(new StatusType(statusTypeId));
        return new ResponseEntity<Object>(new ResponseListDTO(statusList), HttpStatus.OK);
    }

    @Autowired
    public void setStatusTypeService(StatusTypeService statusTypeService) {
        this.statusTypeService = statusTypeService;
    }

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }
}
