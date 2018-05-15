package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Modification;

import java.util.List;

public interface ModificationService {
    void saveModification(Modification modification);

    Modification findModification(Integer modificationId);

    List<Modification> findAllModifications();

    Modification updateModification(Modification modification);
}
