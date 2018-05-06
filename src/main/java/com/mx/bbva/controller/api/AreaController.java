package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Area;
import com.mx.bbva.business.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/areas")
public class AreaController {
    private static final Logger LOG = Logger.getLogger(AreaController.class.getName());

    private AreaService areaService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllAreas() {
        LOG.info("Searching list... Areas");
        List<Area> areas = areaService.findAllAreas();

        return new ResponseEntity<Object>(new ResponseListDTO(areas), HttpStatus.OK);
    }

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }
}
