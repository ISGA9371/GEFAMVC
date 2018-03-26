package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Workplace;
import com.mx.bbva.business.repository.WorkplaceRepository;
import com.mx.bbva.business.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceServiceImpl implements WorkplaceService {
    private WorkplaceRepository workplaceRepository;

    @Override
    public List<Workplace> findAllWorkplaces() {
        return workplaceRepository.findAll();
    }

    @Autowired
    public void setWorkplaceRepository(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }
}
