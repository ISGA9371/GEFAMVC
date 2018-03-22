package com.bbva.bancomer.business.service.implementation;

import com.bbva.bancomer.business.model.Area;
import com.bbva.bancomer.business.repository.AreaRepository;
import com.bbva.bancomer.business.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImp implements AreaService {
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
