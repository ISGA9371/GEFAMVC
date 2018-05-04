package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.ContractType;
import com.mx.bbva.business.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/contract-types")
public class ContractTypeController {
    private static final Logger LOG = Logger.getLogger(ContractTypeController.class.getName());

    private ContractTypeService contractTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllContractTypes() {
        List<ContractType> contractTypes = contractTypeService.findAllContractTypes();
        return new ResponseEntity<Object>(new ResponseListDTO(contractTypes), HttpStatus.OK);
    }

    @Autowired
    public void setContractTypeService(ContractTypeService contractTypeService) {
        this.contractTypeService = contractTypeService;
    }
}
