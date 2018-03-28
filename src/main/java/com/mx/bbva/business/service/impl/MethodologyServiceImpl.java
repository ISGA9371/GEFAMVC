package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Methodology;
import com.mx.bbva.business.repository.MethodologyRepository;
import com.mx.bbva.business.service.MethodologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodologyServiceImpl implements MethodologyService {
    private MethodologyRepository methodologyRepository;

    @Override
    public List<Methodology> findAllMethodologies() {
        return methodologyRepository.findAll();
    }

    @Autowired
    public void setMethodologyRepository(MethodologyRepository methodologyRepository) {
        this.methodologyRepository = methodologyRepository;
    }


}
