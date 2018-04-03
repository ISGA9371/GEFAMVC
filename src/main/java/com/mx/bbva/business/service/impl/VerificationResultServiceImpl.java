package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.VerificationResult;
import com.mx.bbva.business.repository.VerificationResultRepository;
import com.mx.bbva.business.service.VerificationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationResultServiceImpl implements VerificationResultService {
    private VerificationResultRepository verificationResultRepository;

    @Override
    public List<VerificationResult> findAllVerificationResults() {
        return verificationResultRepository.findAll();
    }

    @Autowired
    public void setVerificationResultRepository(VerificationResultRepository verificationResultRepository) {
        this.verificationResultRepository = verificationResultRepository;
    }
}
