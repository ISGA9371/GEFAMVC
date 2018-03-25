package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Doubt;

import java.util.List;

public interface DoubtService {
    List<Doubt> findAllDoubts();

    void saveDoubt(Doubt doubt);

    Doubt findDoubt(Integer doubtId);
}
