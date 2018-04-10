package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAllPayments();
}
