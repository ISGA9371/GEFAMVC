package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.ProgramIncrement;
import com.mx.bbva.business.service.ProgramIncrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/programIncrements")
public class ProgramIncrementController {
    private static final Logger LOG = Logger.getLogger(ProgramIncrementController.class.getName());

    private ProgramIncrementService programIncrementService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllProgramIncrements() {
        List<ProgramIncrement> programIncrements = programIncrementService.findAll();
        return new ResponseEntity<Object>(new ResponseListDTO(programIncrements), HttpStatus.OK);
    }

    @Autowired
    public void setProgramIncrementService(ProgramIncrementService programIncrementService) {
        this.programIncrementService = programIncrementService;
    }
}
