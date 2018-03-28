package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Area;
import com.mx.bbva.business.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAllServiceTypes();


    List<ServiceType> findAllByArea(Area area);
}
