package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Invoice;

import java.util.Date;
import java.util.List;

public interface InvoiceService {
    List<Invoice> findAllInvoices();

    List<Date> findAllInvoiceSendDates();

    List<Date> findAllInvoiceCutDates();

    List<Invoice> findByCustomQuery(String query);
}
