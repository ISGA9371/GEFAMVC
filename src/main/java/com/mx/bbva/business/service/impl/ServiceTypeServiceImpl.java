package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.model.ServiceType;
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

    @Autowired
    public void setServiceTypeRepository(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }
}
