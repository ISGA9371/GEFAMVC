package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Banking;
import com.mx.bbva.business.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/bankings")
public class BankingController {
    private static final Logger LOG = Logger.getLogger(BankingController.class.getName());

    private BankingService bankingService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllBankings() {
        List<Banking> bankings = bankingService.findAllBanking();
        return new ResponseEntity<Object>(new ResponseListDTO(bankings), HttpStatus.OK);
    }

    @Autowired
    public void setBankingService(BankingService bankingService) {
        this.bankingService = bankingService;
    }
}
