package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.BudgetsApplicant;
import com.mx.bbva.business.service.BudgetsApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/budgets-applicants")
public class BudgetsApplicantController {
    private static final Logger LOG = Logger.getLogger(BudgetsApplicantController.class.getName());

    private BudgetsApplicantService budgetsApplicantService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllBudgetsApplicants() {
        LOG.info("Searching list... BudgetsApplicants");
        List<BudgetsApplicant> budgetsApplicants = budgetsApplicantService.findAllBudgetsApplicants();

        return new ResponseEntity<Object>(new ResponseListDTO(budgetsApplicants), HttpStatus.OK);
    }

    @Autowired
    public void setBudgetsApplicantService(BudgetsApplicantService budgetsApplicantService) {
        this.budgetsApplicantService = budgetsApplicantService;
    }
}
