package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Invoice;
import com.mx.bbva.business.repository.InvoiceRepository;
import com.mx.bbva.business.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Date> findAllInvoiceSendDates() {
        return invoiceRepository.findInvoiceSendDate();
    }

    @Override
    public List<Date> findAllInvoiceCutDates() {
        return invoiceRepository.findInvoiceCutDate();
    }

    @Autowired
    public void setInvoiceRepository(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}
