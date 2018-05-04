package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Company;
import com.mx.bbva.business.repository.specs.CompanySpecificationsBuilder;
import com.mx.bbva.business.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/api/companies")
public class CompanyController {
    private static final Logger LOG = Logger.getLogger(CompanyController.class.getName());

    private CompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllCompanies() {
        // TODO Validate user
        List<Company> companies = companyService.findAllCompanies(null);
        return new ResponseEntity<Object>(new ResponseListDTO(companies), HttpStatus.OK);
    }

    // TODO TESTING ONLY
    /*
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<?> search(@RequestParam(value = "search") String search) {
        CompanySpecificationsBuilder builder = new CompanySpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Company> spec = builder.build();
        return new ResponseEntity<Object>(new ResponseListDTO(companyService.findAllCompanies(spec)), HttpStatus.OK);
    }*/

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

}
