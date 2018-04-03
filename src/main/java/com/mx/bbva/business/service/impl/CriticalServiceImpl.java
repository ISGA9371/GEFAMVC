package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Critical;
import com.mx.bbva.business.repository.CriticalRepository;
import com.mx.bbva.business.service.CriticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriticalServiceImpl implements CriticalService {
    private CriticalRepository criticalRepository;

    @Override
    public List<Critical> findAllCriticals() {
        return criticalRepository.findAll();
    }

    @Autowired
    public void setCriticalRepository(CriticalRepository criticalRepository) {
        this.criticalRepository = criticalRepository;
    }
}
