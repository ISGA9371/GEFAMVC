package com.bbva.bancomer.business.service.implementation;


import com.bbva.bancomer.business.model.Company;
import com.bbva.bancomer.business.model.Technology;
import com.bbva.bancomer.business.repository.CompanyRepository;
import com.bbva.bancomer.business.repository.TechnologyRepository;
import com.bbva.bancomer.business.service.CompanyService;
import com.bbva.bancomer.business.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
}
