package com.mx.bbva.controller.api;

import com.mx.bbva.business.dto.ResponseListDTO;
import com.mx.bbva.business.entity.Country;
import com.mx.bbva.business.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/countries")
public class CountryController {
    private static final Logger LOG = Logger.getLogger(CountryController.class.getName());

    private CountryService countryService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findAllCountries() {
        List<Country> countries = countryService.findAllCountries();
        return new ResponseEntity<Object>(new ResponseListDTO(countries), HttpStatus.OK);
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }
}
