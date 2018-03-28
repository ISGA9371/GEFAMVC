package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Area;
import com.mx.bbva.business.entity.ServiceType;
import com.mx.bbva.business.repository.ServiceTypeRepository;
import com.mx.bbva.business.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAllServiceTypes() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public List<ServiceType> findAllByArea(Area area) {
        return serviceTypeRepository.findByArea(area);
    }

    @Autowired
    public void setServiceTypeRepository(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }
}
