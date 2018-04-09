package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Fare;

import java.util.List;

public interface FareService {
    List<Fare> findAllFares();

    Fare findRequirementFare(Integer companyId, Integer technologyId, Integer areaId);
}
