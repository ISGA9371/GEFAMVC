package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Priority;
import com.mx.bbva.business.repository.PriorityRepository;
import com.mx.bbva.business.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {
    private PriorityRepository priorityRepository;

    @Override
    public List<Priority> findAllPriorities() {
        return priorityRepository.findAll();
    }

    @Autowired
    public void setPriorityRepository(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }
}
