package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Status;
import com.mx.bbva.business.repository.StatusRepository;
import com.mx.bbva.business.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    private StatusRepository statusRepository;

    @Override
    public List<Status> findAllStatus() {
        return statusRepository.findAll();
    }

    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
}
