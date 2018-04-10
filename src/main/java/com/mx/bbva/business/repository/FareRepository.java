package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Area;
import com.mx.bbva.business.entity.Company;
import com.mx.bbva.business.entity.Fare;
import com.mx.bbva.business.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FareRepository extends JpaRepository<Fare, Integer> {
    Fare findByCompanyAndTechnologyAndArea(Company company, Technology technology, Area area);
}
