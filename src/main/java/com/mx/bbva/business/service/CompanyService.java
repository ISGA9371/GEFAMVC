package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Company;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CompanyService {
    void saveCompany(Company company);

    Company findCompany(Integer companyId);

    List<Company> findAllCompanies(Specification<Company> spec);

    List<Company> findAllCompaniesForDropDownList();
}
