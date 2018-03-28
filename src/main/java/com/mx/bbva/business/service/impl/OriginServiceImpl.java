package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Origin;
import com.mx.bbva.business.repository.OriginRepository;
import com.mx.bbva.business.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginServiceImpl implements OriginService {
    private OriginRepository originRepository;

    @Override
    public List<Origin> findAllOrigins() {
        return originRepository.findAll();
    }

    @Autowired
    public void setOriginRepository(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }
}
