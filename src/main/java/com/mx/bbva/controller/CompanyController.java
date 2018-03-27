package com.mx.bbva.controller;

import com.mx.bbva.business.entity.Company;
import com.mx.bbva.business.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

import static com.mx.bbva.util.ViewsURLs.*;

@Controller
@RequestMapping(value = "/companies")
public class CompanyController {
    private static final Logger LOG = Logger.getLogger(CompanyController.class.getName());

    private CompanyService companyService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String createCompany(Model model) {
        // TODO Validate user

        LOG.info("Creating new company");
        model.addAttribute("company", new Company());
        //TODO Add catalogs
        return URL_FACTORY + NEW_COMPANY;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("companye") Company company) {
        // TODO Validate user

        // LOG.info("Saving new company... " + company.getCompanyName());
        companyService.saveCompany(company);

        return URL_FACTORY + EDIT_COMPANY;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAllCompanies(Model model) {
        // TODO Validate user
        List<Company> companies = companyService.findAllCompaniesForDropDownList();
        model.addAttribute("companies", companies);
        return URL_FACTORY + SEARCH_COMPANIES;
    }

    @RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
    public String editCompany(Model model, @PathVariable(value = "companyId") Integer companyId) {
        // TODO Validate user
        LOG.info("Updating company, ID: " + companyId);
        if (null != companyId) {
            Company company = companyService.findCompany(companyId);
            model.addAttribute("company", company);
        } else {
            model.addAttribute("company", new Company());
        }
        return URL_FACTORY + EDIT_COMPANY;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

}
