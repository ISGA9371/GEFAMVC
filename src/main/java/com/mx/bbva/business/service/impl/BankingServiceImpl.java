package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Banking;
import com.mx.bbva.business.repository.BankingRepository;
import com.mx.bbva.business.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingServiceImpl implements BankingService {
    private BankingRepository bankingRepository;

    @Override
    public List<Banking> findAllBanking() {
        return bankingRepository.findAll();
    }

    @Autowired
    public void setBankingRepository(BankingRepository bankingRepository) {
        this.bankingRepository = bankingRepository;
    }
}
