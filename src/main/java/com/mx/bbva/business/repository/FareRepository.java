package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FareRepository extends JpaRepository<Fare, Integer> {
    Fare findFareValueByCompanyAndTechnologyAndAreaAndStatus(Company company, Technology technology, Area area, Status status);
}
