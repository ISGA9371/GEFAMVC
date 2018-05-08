package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.ResourceClassification;
import com.mx.bbva.business.entity.ResourceSubClassification;
import com.mx.bbva.business.service.ResourceClassificationService;
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
@RequestMapping(value = "/api/resource-classifications")
public class ResourceClassificationController {
    private static final Logger LOG = Logger.getLogger(ResourceClassificationController.class.getName());

    private ResourceClassificationService resourceClassificationService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllResourceClassifications() {
        LOG.info("Searching list... ResourceClassifications");

        List<ResourceClassification> resourceClassifications = resourceClassificationService.findAllResourceClassifications();
        return new ResponseEntity<Object>(new ResponseListDTO(resourceClassifications), HttpStatus.OK);
    }

    @RequestMapping(value = "{resourceClassificationId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findResourceSubClassification(
            @PathVariable("resourceClassificationId") Integer resourceClassificationId) {
        LOG.info("Searching one... ResourceClassification: " + resourceClassificationId);

        ResourceClassification resourceClassification = resourceClassificationService
                .findResourceClassification(resourceClassificationId);

        return new ResponseEntity<Object>(new ResponseDTO(resourceClassification), HttpStatus.OK);
    }

    @RequestMapping(value = "{resourceClassificationId}/sub-classifications", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllResourceSubClassifications(
            @PathVariable("resourceClassificationId") Integer resourceClassificationId) {
        LOG.info("Searching List... ResourceSubClassification by: " + resourceClassificationId);

        List<ResourceSubClassification> subClassifications = resourceClassificationService
                .findAllSubClassifications(resourceClassificationId);

        return new ResponseEntity<Object>(new ResponseListDTO(subClassifications), HttpStatus.OK);
    }

    @Autowired
    public void setResourceClassificationService(ResourceClassificationService resourceClassificationService) {
        this.resourceClassificationService = resourceClassificationService;
    }
}
