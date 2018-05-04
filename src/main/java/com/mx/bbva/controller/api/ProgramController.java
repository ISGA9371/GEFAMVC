package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Program;
import com.mx.bbva.business.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/programs")
public class ProgramController {
    private static final Logger LOG = Logger.getLogger(ProgramController.class.getName());

    private ProgramService programService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllPrograms() {
        List<Program> programs = programService.findAllPrograms();
        return new ResponseEntity<Object>(new ResponseListDTO(programs), HttpStatus.OK);
    }

    @Autowired
    public void setProgramService(ProgramService programService) {
        this.programService = programService;
    }
}
