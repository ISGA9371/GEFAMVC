package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Status;
import com.mx.bbva.business.entity.StatusType;

import java.util.List;

public interface StatusService {
    List<Status> findAllStatus();

    List<Status> findStatusByType(StatusType statusType);
}
