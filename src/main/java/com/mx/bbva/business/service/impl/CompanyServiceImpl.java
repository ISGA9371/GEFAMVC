package com.mx.bbva.business.service.impl;


import com.mx.bbva.business.entity.Company;
import com.mx.bbva.business.repository.CompanyRepository;
import com.mx.bbva.business.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company findCompany(Integer companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }

    @Override
    public List<Company> findAllCompanies(Specification<Company> spec) {
        return companyRepository.findAll(spec);
    }

    @Override
    public List<Company> findAllCompaniesForDropDownList() {
        return companyRepository.findAllCompaniesOnlyIdAndName();
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
