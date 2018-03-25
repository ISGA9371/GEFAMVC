package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Area;
import com.mx.bbva.business.repository.AreaRepository;
import com.mx.bbva.business.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    private AreaRepository areaRepository;

    @Override
    public List<Area> findAllAreas() {
        return areaRepository.findAll();
    }

    @Autowired
    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
}
