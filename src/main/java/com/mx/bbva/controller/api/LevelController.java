package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.service.LevelService;
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
@RequestMapping(value = "/api/levels")
public class LevelController {
    private static final Logger LOG = Logger.getLogger(LevelController.class.getName());

    private LevelService levelService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllLevels() {
        LOG.info("find levels...");
        List<Level> levels = levelService.findAllLevels();
        return new ResponseEntity<Object>(new ResponseListDTO(levels), HttpStatus.OK);
    }

    @RequestMapping(value = "/{levelId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getOneLevel(@PathVariable(name = "levelId") Integer levelId) {
        LOG.info("find sub-levels..." + levelId);
        Level level = levelService.findOneLevel(levelId);
        return new ResponseEntity<Object>(new ResponseDTO(level), HttpStatus.OK);
    }

    @RequestMapping(value = "/{levelId}/sub-levels", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllSubLevels(@PathVariable(name = "levelId") Integer levelId) {
        LOG.info("find sub-levels..." + levelId);
        List<Level> levels = levelService.findSubLevels(levelId);
        return new ResponseEntity<Object>(new ResponseListDTO(levels), HttpStatus.OK);
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

}
