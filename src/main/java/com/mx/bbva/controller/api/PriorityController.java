package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Priority;
import com.mx.bbva.business.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/prioritys")
public class PriorityController {
    private static final Logger LOG = Logger.getLogger(PriorityController.class.getName());

    private PriorityService priorityService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllPriorities() {
        List<Priority> prioritys = priorityService.findAllPriorities();
        return new ResponseEntity<Object>(new ResponseListDTO(prioritys), HttpStatus.OK);
    }

    @Autowired
    public void setPriorityService(PriorityService priorityService) {
        this.priorityService = priorityService;
    }
}
