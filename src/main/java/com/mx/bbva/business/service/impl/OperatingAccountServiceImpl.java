package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.OperatingAccount;
import com.mx.bbva.business.repository.OperatingAccountRepository;
import com.mx.bbva.business.service.OperatingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatingAccountServiceImpl implements OperatingAccountService {
    private OperatingAccountRepository operatingAccountRepository;

    @Override
    public List<OperatingAccount> findAllOperatingAccounts() {
        return operatingAccountRepository.findAll();
    }

    @Autowired
    public void setOperatingAccountRepository(OperatingAccountRepository operatingAccountRepository) {
        this.operatingAccountRepository = operatingAccountRepository;
    }
}
