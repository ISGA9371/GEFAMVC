package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.AssignationType;
import com.mx.bbva.business.service.AssignationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/assignation-types")
public class AssignationTypeController {
    private static final Logger LOG = Logger.getLogger(AssignationTypeController.class.getName());

    private AssignationTypeService assignationTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllAssignationTypes() {
        List<AssignationType> assignationTypes = assignationTypeService.findAllAssignationTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(assignationTypes), HttpStatus.OK);
    }

    @Autowired
    public void setAssignationTypeService(AssignationTypeService assignationTypeService) {
        this.assignationTypeService = assignationTypeService;
    }
}
