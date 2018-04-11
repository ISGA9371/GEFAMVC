package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Doubt;
import com.mx.bbva.business.entity.DoubtType;

import java.util.List;

public interface DoubtService {
    List<Doubt> findAllDoubts();

    void saveDoubt(Doubt doubt);

    Doubt findDoubt(Integer doubtId);

    List<DoubtType> findAllDoubtTypes();
}
