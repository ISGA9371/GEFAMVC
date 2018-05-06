package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.TestCaseCategory;
import com.mx.bbva.business.service.TestCaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/test-case-categories")
public class TestCaseCategoryController {
    private static final Logger LOG = Logger.getLogger(TestCaseCategoryController.class.getName());

    private TestCaseCategoryService testCaseCategoryService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllTestCaseCategories() {
        LOG.info("Searching list... TestCaseCategories");
        List<TestCaseCategory> testCaseCategories = testCaseCategoryService.findAllTestCaseCategories();

        return new ResponseEntity<Object>(new ResponseListDTO(testCaseCategories), HttpStatus.OK);
    }

    @Autowired
    public void setTestCaseCategoryService(TestCaseCategoryService testCaseCategoryService) {
        this.testCaseCategoryService = testCaseCategoryService;
    }
}
