package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.entity.Transfer;

import java.util.Collection;
import java.util.List;

public interface TransferService {
    void saveTransfer(Transfer transfer);

    Transfer findTransfer(Integer transferId);

    List<Transfer> findAllTransfers();

    List<Transfer> findTransfersByBudget(Budget budget);
}
