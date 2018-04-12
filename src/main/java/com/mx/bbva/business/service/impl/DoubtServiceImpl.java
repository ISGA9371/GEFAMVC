package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Doubt;
import com.mx.bbva.business.entity.DoubtType;
import com.mx.bbva.business.entity.Status;
import com.mx.bbva.business.repository.DoubtRepository;
import com.mx.bbva.business.repository.DoubtTypeRepository;
import com.mx.bbva.business.service.DoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoubtServiceImpl implements DoubtService {
    private DoubtRepository doubtRepository;
    private DoubtTypeRepository doubtTypeRepository;

    @Override
    public List<Doubt> findAllDoubts() {
        return doubtRepository.findAll();
    }

    @Override
    public void saveDoubt(Doubt doubt) {
        if (doubt.getDoubtId() == null) {
            // TODO Use enums
            doubt.setStatus(new Status(11));
        }
        doubtRepository.save(doubt);
    }

    @Override
    public Doubt findDoubt(Integer doubtId) {
        return doubtRepository.findById(doubtId).orElse(null);
    }

    @Override
    public List<DoubtType> findAllDoubtTypes() {
        return doubtTypeRepository.findAll();
    }

    @Autowired
    public void setDoubtRepository(DoubtRepository doubtRepository) {
        this.doubtRepository = doubtRepository;
    }

    @Autowired
    public void setDoubtTypeRepository(DoubtTypeRepository doubtTypeRepository) {
        this.doubtTypeRepository = doubtTypeRepository;
    }
}
