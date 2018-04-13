package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.StatusType;
import com.mx.bbva.business.repository.StatusTypeRepository;
import com.mx.bbva.business.service.StatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusTypeServiceImpl implements StatusTypeService {
    private StatusTypeRepository statusTypeRepository;

    @Override
    public List<StatusType> findAllStatusTypes() {
        return statusTypeRepository.findAll();
    }

    @Override
    public StatusType findOneStatusType(Integer statusTypeId) {
        return statusTypeRepository.findById(statusTypeId).orElse(null);
    }

    @Autowired
    public void setStatusTypeRepository(StatusTypeRepository statusTypeRepository) {
        this.statusTypeRepository = statusTypeRepository;
    }
}
