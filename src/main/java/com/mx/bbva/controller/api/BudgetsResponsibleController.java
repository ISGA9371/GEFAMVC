package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.BudgetsResponsible;
import com.mx.bbva.business.service.BudgetsResponsibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/budgets-responsible")
public class BudgetsResponsibleController {
    private static final Logger LOG = Logger.getLogger(BudgetsResponsibleController.class.getName());

    private BudgetsResponsibleService budgetsResponsibleService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllBudgetsResponsibles() {
        LOG.info("Searching list... BudgetsResponsibles");
        List<BudgetsResponsible> budgetsResponsibles = budgetsResponsibleService.findAllBudgetsResponsible();

        return new ResponseEntity<Object>(new ResponseListDTO(budgetsResponsibles), HttpStatus.OK);
    }

    @Autowired
    public void setBudgetsResponsibleService(BudgetsResponsibleService budgetsResponsibleService) {
        this.budgetsResponsibleService = budgetsResponsibleService;
    }
}
