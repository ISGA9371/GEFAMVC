package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.OperatingAccount;

import java.util.List;

public interface OperatingAccountService {
    List<OperatingAccount> findAllOperatingAccounts();
}
