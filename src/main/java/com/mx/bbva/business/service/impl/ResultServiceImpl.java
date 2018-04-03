package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Result;
import com.mx.bbva.business.repository.ResultRepository;
import com.mx.bbva.business.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    private ResultRepository resultRepository;

    @Override
    public List<Result> findAllResults() {
        return resultRepository.findAll();
    }

    @Autowired
    public void setResultRepository(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }
}
