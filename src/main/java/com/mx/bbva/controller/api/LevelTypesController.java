package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.LevelType;
import com.mx.bbva.business.service.LevelService;
import com.mx.bbva.business.service.LevelTypeService;
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
@RequestMapping("/api/level-types")
public class LevelTypesController {
    private static final Logger LOGGER = Logger.getLogger(LevelTypesController.class.getName());

    private LevelService levelService;
    private LevelTypeService levelTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllLevelTypes() {
        LOGGER.info("find level...");
        List<LevelType> levelList = levelTypeService.findAllLevelTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(levelList), org.springframework.http.HttpStatus.OK);
    }

    @RequestMapping(value = "/{levelTypeId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getLevelType(@PathVariable(name = "levelTypeId") Integer levelTypeId) {
        LOGGER.info("find level..." + levelTypeId);
        LevelType level = levelTypeService.findOneLevelType(levelTypeId);
        return new ResponseEntity<Object>(new ResponseDTO(level), HttpStatus.OK);
    }

    @RequestMapping(value = "/{levelTypeId}/levels", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllLevelByType(@PathVariable(name = "levelTypeId") Integer levelTypeId) {
        LOGGER.info("find level by type..." + levelTypeId);
        List<Level> levelList = levelService.findByLevelType(new LevelType(levelTypeId));
        return new ResponseEntity<Object>(new ResponseListDTO(levelList), HttpStatus.OK);
    }

    @Autowired
    public void setLevelTypeService(LevelTypeService levelTypeService) {
        this.levelTypeService = levelTypeService;
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }
}
