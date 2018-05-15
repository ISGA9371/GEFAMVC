package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseDTO;
import com.mx.bbva.business.entity.Modification;
import com.mx.bbva.business.service.ModificationService;
import com.mx.bbva.config.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/modifications")
public class ModificationsController {

    private ModificationService modificationService;

    @RequestMapping(value = "{modificationId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findModification(@PathVariable("modificationId") Integer modificationId) {
        // TODO Check user / session

        Modification modification = modificationService.findModification(modificationId);

        return new ResponseEntity<Object>(new ResponseDTO(modification), HttpStatus.OK);
    }

    @RequestMapping(value = "{modificationId}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> updateModification(@PathVariable("modificationId") Integer modificationId,
                                                @RequestBody Modification modification) {
        // TODO Check user / session
        if (modificationService.notExist(modificationId)) {
            throw new NotFoundException("NO EXISTE");
        }

        Modification modificationUpdated = modificationService.updateModification(modification);

        return new ResponseEntity<Object>(new ResponseDTO(modificationUpdated), HttpStatus.OK);
    }

    @Autowired
    public void setModificationService(ModificationService modificationService) {
        this.modificationService = modificationService;
    }
}
