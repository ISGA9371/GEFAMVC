package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.PriorityTestCase;
import com.mx.bbva.business.service.PriorityTestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/priority-test-cases")
public class PriorityTestCaseController {
    private static final Logger LOG = Logger.getLogger(PriorityTestCaseController.class.getName());

    private PriorityTestCaseService priorityTestCaseService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllPriorityTestCases() {
        List<PriorityTestCase> priorityTestCases = priorityTestCaseService.findAllPriorityTestCases();
        return new ResponseEntity<Object>(new ResponseListDTO(priorityTestCases), HttpStatus.OK);
    }

    @Autowired
    public void setPriorityTestCaseService(PriorityTestCaseService priorityTestCaseService) {
        this.priorityTestCaseService = priorityTestCaseService;
    }
}
