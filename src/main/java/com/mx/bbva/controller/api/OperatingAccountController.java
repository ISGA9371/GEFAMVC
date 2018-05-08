package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.OperatingAccount;
import com.mx.bbva.business.service.OperatingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/operating-accounts")
public class OperatingAccountController {
    private static final Logger LOG = Logger.getLogger(OperatingAccountController.class.getName());

    private OperatingAccountService operatingAccountService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllOperatingAccounts() {
        LOG.info("Searching list... OperatingAccounts");
        List<OperatingAccount> operatingAccounts = operatingAccountService.findAllOperatingAccounts();

        return new ResponseEntity<Object>(new ResponseListDTO(operatingAccounts), HttpStatus.OK);
    }

    @Autowired
    public void setOperatingAccountService(OperatingAccountService operatingAccountService) {
        this.operatingAccountService = operatingAccountService;
    }
}
