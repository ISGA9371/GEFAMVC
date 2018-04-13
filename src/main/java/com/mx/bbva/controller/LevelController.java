package com.mx.bbva.controller;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.LevelType;
import com.mx.bbva.business.service.LevelService;
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
@RequestMapping(value = "/levels")
public class LevelController {
    private static final Logger LOG = Logger.getLogger(LevelController.class.getName());

    private LevelService levelService;

    @RequestMapping(value = "/{superiorLevelId}/sub-level", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findByLevelType(@PathVariable("superiorLevelId") Integer superiorLevelId) {
        List<Level> levels = levelService.findByLevelSuperior(superiorLevelId);
        return new ResponseEntity<Object>(new ResponseListDTO(levels), HttpStatus.OK);
    }

    @RequestMapping(value = "/{levelTypeId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllLevelsByType(@PathVariable(name = "levelTypeId", required = false) Integer levelTypeId) {
        LOG.info("find levels by type ..." + levelTypeId);
        List<Level> levels = this.levelService.findByLevelType(new LevelType(levelTypeId));
        return new ResponseEntity<Object>(new ResponseListDTO(levels), HttpStatus.OK);
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

}
