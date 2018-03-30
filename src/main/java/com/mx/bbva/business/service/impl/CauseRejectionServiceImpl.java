package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.CauseRejection;
import com.mx.bbva.business.repository.CauseRejectionRepository;
import com.mx.bbva.business.service.CauseRejectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CauseRejectionServiceImpl implements CauseRejectionService {
    private CauseRejectionRepository causeRejectionRepository;

    @Override
    public List<CauseRejection> findAllCauseRejections() {
        return causeRejectionRepository.findAll();
    }

    @Autowired
    public void setCauseRejectionRepository(CauseRejectionRepository causeRejectionRepository) {
        this.causeRejectionRepository = causeRejectionRepository;
    }
}
