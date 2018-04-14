package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.ServiceType;
import com.mx.bbva.business.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/service-types")
public class ServiceTypeController {
    private static final Logger LOG = Logger.getLogger(ServiceTypeController.class.getName());

    private ServiceTypeService serviceTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllServiceTypes() {
        List<ServiceType> serviceTypes = serviceTypeService.findAllServiceTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(serviceTypes), HttpStatus.OK);
    }

    @Autowired
    public void setServiceTypeService(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }
}
