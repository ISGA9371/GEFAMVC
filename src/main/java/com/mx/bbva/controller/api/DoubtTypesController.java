package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.DoubtType;
import com.mx.bbva.business.service.DoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/doubt-types")
public class DoubtTypesController {
    private static final Logger LOGGER = Logger.getLogger(DoubtTypesController.class.getName());

    private DoubtService doubtService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getAllDoubtTypes() {
        LOGGER.info("find doubt types...");
        List<DoubtType> doubtList = doubtService.findAllDoubtTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(doubtList), HttpStatus.OK);
    }

    @Autowired

    public void setDoubtService(DoubtService doubtService) {
        this.doubtService = doubtService;
    }
}
