package com.mx.bbva.business.service.impl;


import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.entity.Transfer;
import com.mx.bbva.business.repository.BudgetRepository;
import com.mx.bbva.business.repository.TransferRepository;
import com.mx.bbva.business.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    private TransferRepository transferRepository;
    private BudgetRepository budgetRepository;

    private final List<Long> budgetDydStatusId = Collections.singletonList(42L);

    @Override
    public Transfer saveTransfer(Transfer transfer) {
        return transferRepository.saveAndFlush(transfer);
    }

    @Override
    public Transfer findTransfer(Integer transferId) {
        return transferRepository.findById(transferId).orElse(null);
    }

    @Override
    public List<Transfer> findAllTransfers() {
        List<Transfer> transfers = transferRepository.findAll();
        for (Transfer transfer : transfers) {
            Budget budgetDb = transfer.getBudgetDb();
            budgetDb.setTransfers(null);
            transfer.setBudget(budgetDb);
        }
        return transfers;
    }

    @Override
    public List<Transfer> findTransfersByBudget(Budget budget) {
        return transferRepository.findByBudgetDbAndBudgetDb_StatusDyd_StatusIdIn(budget, budgetDydStatusId);
    }

    @Autowired
    public void setTransferRepository(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }
}
