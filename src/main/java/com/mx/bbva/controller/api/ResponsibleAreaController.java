package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.ResponsibleArea;
import com.mx.bbva.business.service.ResponsibleAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/responsible-areas")
public class ResponsibleAreaController {
    private static final Logger LOG = Logger.getLogger(ResponsibleAreaController.class.getName());

    private ResponsibleAreaService responsibleAreaService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllResponsibleAreas() {
        LOG.info("Searching list... ResponsibleAreas");
        List<ResponsibleArea> responsibleAreas = responsibleAreaService.findAllResponsibleAreas();

        return new ResponseEntity<Object>(new ResponseListDTO(responsibleAreas), HttpStatus.OK);
    }

    @Autowired
    public void setResponsibleAreaService(ResponsibleAreaService responsibleAreaService) {
        this.responsibleAreaService = responsibleAreaService;
    }
}
