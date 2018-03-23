package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Company;
import com.bbva.bancomer.business.model.Technology;

import java.util.List;

public interface TechnologyService {
    List<Technology> findAllTechnologies();
}
