package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.VerificationResult;

import java.util.List;

public interface VerificationResultService {
    List<VerificationResult> findAllVerificationResults();
}
