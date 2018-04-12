package com.mx.bbva.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.LevelType;
import com.mx.bbva.business.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/levels")
public class LevelController {
    private static final Logger LOG = Logger.getLogger(LevelController.class.getName());

    private LevelService levelService;

    @GetMapping(value = "/{superiorlevelId}/sublevel", produces = "application/json")
    @ResponseBody
    @Transactional
    public String findByLevelType(@PathVariable Integer superiorlevelId) {
        // TODO Validate IN values
        List<Level> levels = levelService.findByLevelSuperior(superiorlevelId);

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(levels);
        } catch (JsonProcessingException e) {
            LOG.severe("EXC: " + e.getMessage());
        }

        return jsonStr;
    }

    @RequestMapping(value = "/types/{levelTypeId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllLevelsByType(@PathVariable("levelTypeId") Integer levelTypeId) {
        LOG.info("find levels by type ..." + levelTypeId);
        List<Level> levels = this.levelService.findByLevelType(new LevelType(levelTypeId));
        return new ResponseEntity<Object>(new ResponseListDTO(levels), HttpStatus.OK);
    }

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

}
