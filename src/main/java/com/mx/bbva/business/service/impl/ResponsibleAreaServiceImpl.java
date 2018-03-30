package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.ResponsibleArea;
import com.mx.bbva.business.repository.ResponsibleAreaRepository;
import com.mx.bbva.business.service.ResponsibleAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsibleAreaServiceImpl implements ResponsibleAreaService {
    private ResponsibleAreaRepository responsibleAreaRepository;

    @Override
    public List<ResponsibleArea> findAllResponsibleAreas() {
        return responsibleAreaRepository.findAll();
    }

    @Autowired
    public void setResponsibleAreaRepository(ResponsibleAreaRepository responsibleAreaRepository) {
        this.responsibleAreaRepository = responsibleAreaRepository;
    }
}
