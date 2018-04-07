package com.mx.bbva.business.service.impl;


import com.mx.bbva.business.entity.Transfer;
import com.mx.bbva.business.repository.TransferRepository;
import com.mx.bbva.business.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    private TransferRepository transferRepository;

    @Override
    public void saveTransfer(Transfer transfer) {
        transferRepository.save(transfer);
    }

    @Override
    public Transfer findTransfer(Integer transferId) {
        return transferRepository.findById(transferId).orElse(null);
    }

    @Override
    public List<Transfer> findAllTransfers() {
        return transferRepository.findAll();
    }

    @Autowired
    public void setTransferRepository(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }
}
