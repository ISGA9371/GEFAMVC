package com.mx.bbva.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.bbva.business.entity.Area;
import com.mx.bbva.business.entity.Level;
import com.mx.bbva.business.entity.ServiceType;
import com.mx.bbva.business.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/service-types")
public class ServiceTypeController {

    private static final Logger LOG = Logger.getLogger(ServiceTypeController.class.getName());

    private ServiceTypeService serviceTypeService;

    @GetMapping(value = "/area/{belongingArea}", produces = "application/json")
    @ResponseBody
    public String findByBelongingArea(@PathVariable Integer belongingArea){
        List<ServiceType> services = serviceTypeService.findAllByArea(new Area(belongingArea));

        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(services);
        } catch (JsonProcessingException e) {
            LOG.severe("EXC: "+e.getMessage());
        }

        return jsonStr;
    }

    @Autowired
    public void setServiceTypeService(ServiceTypeService serviceTypeService){
        this.serviceTypeService = serviceTypeService;
    }
}
