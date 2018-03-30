package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.CauseClosure;
import com.mx.bbva.business.repository.CauseClosureRepository;
import com.mx.bbva.business.service.CauseClosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CauseClosureServiceImpl implements CauseClosureService {
    private CauseClosureRepository causeClosureRepository;

    @Override
    public List<CauseClosure> findAllCauseClosures() {
        return causeClosureRepository.findAll();
    }

    @Autowired
    public void setCauseClosureRepository(CauseClosureRepository causeClosureRepository) {
        this.causeClosureRepository = causeClosureRepository;
    }
}
