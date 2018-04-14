package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Company;
import com.mx.bbva.business.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/companies")
public class CompanyController {
    private static final Logger LOG = Logger.getLogger(CompanyController.class.getName());

    private CompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllCompanies() {
        // TODO Validate user
        List<Company> companies = companyService.findAllCompanies();
        return new ResponseEntity<Object>(new ResponseListDTO(companies), HttpStatus.OK);
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

}
