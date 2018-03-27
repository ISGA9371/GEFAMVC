package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAllCompanies();

    List<Company> findAllCompaniesForDropDownList();
}
