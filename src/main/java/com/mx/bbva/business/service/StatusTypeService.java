package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.StatusType;

import java.util.List;

public interface StatusTypeService {
    List<StatusType> findAllStatusTypes();

    StatusType findOneStatusType(Integer statusTypeId);
}
