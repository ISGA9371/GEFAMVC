package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Modification;
import com.mx.bbva.business.repository.ModificationRepository;
import com.mx.bbva.business.service.ModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModificationServiceImpl implements ModificationService {
    private ModificationRepository modificationRepository;

    @Override
    public void saveModification(Modification modification) {
        modificationRepository.save(modification);
    }

    @Override
    public Modification findModification(Integer modificationId) {
        return modificationRepository.findById(modificationId).orElse(null);
    }

    @Override
    public List<Modification> findAllModifications() {
        return modificationRepository.findAll();
    }

    @Autowired
    public void setModificationRepository(ModificationRepository modificationRepository) {
        this.modificationRepository = modificationRepository;
    }
}