package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Doubt;
import com.mx.bbva.business.repository.DoubtRepository;
import com.mx.bbva.business.service.DoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoubtServiceImpl implements DoubtService {
    private DoubtRepository doubtRepository;

    @Override
    public List<Doubt> findAllDoubts() {
        return doubtRepository.findAll();
    }

    @Override
    public void saveDoubt(Doubt doubt) {
        doubtRepository.save(doubt);
    }

    @Override
    public Doubt findDoubt(Integer doubtId) {
        return doubtRepository.findById(doubtId).orElse(null);
    }

    @Autowired
    public void setDoubtRepository(DoubtRepository doubtRepository) {
        this.doubtRepository = doubtRepository;
    }
}
