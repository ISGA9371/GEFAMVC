package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Invoice;

import java.util.List;

public interface InvoiceRepositoryCustom {
    List<Invoice> findByCustomQuery(String query);
}
