package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Fare;
import com.mx.bbva.business.entity.Requirement;

import java.util.List;

public interface FareService {
    List<Fare> findAllFares();

    Double findByRequirement(Requirement requirement);
}
