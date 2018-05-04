package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Workplace;
import com.mx.bbva.business.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/workplaces")
public class WorkplaceController {
    private static final Logger LOG = Logger.getLogger(WorkplaceController.class.getName());

    private WorkplaceService workplaceService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllWorkplaces() {
        List<Workplace> workplaces = workplaceService.findAllWorkplaces();
        return new ResponseEntity<Object>(new ResponseListDTO(workplaces), HttpStatus.OK);
    }

    @Autowired
    public void setWorkplaceService(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }
}
