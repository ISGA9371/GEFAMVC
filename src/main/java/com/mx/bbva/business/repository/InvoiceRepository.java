package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "SELECT i.invoiceCutDate FROM Invoice i")
    List<Date> findInvoiceCutDate();

    @Query(value = "SELECT i.invoiceSendDate FROM Invoice i")
    List<Date> findInvoiceSendDate();
}
