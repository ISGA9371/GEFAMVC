package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {
    @Query(value = "SELECT NEW com.mx.bbva.business.entity.Company(c.companyId, c.companyName) FROM Company c")
    List<Company> findAllCompaniesOnlyIdAndName();
}
