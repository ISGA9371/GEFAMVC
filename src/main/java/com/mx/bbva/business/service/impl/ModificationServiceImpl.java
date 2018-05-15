package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.*;
import com.mx.bbva.business.repository.FareRepository;
import com.mx.bbva.business.repository.ModificationRepository;
import com.mx.bbva.business.service.ModificationService;
import com.mx.bbva.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModificationServiceImpl implements ModificationService {
    private ModificationRepository modificationRepository;
    private FareRepository fareRepository;

    @Override
    public void saveModification(Modification modification) {
        if (modification.getModificationId() == null) {
            // TODO Use enums
            modification.setUserSender(new User("XMY3070"));
            modification.setStatus(new Status(5));
            modification.setModificationSendDate(new DateUtils().getCurrentDate());
        }
        modificationRepository.save(modification);
    }

    @Override
    public Modification findModification(Integer modificationId) {
        Modification modification = modificationRepository.findById(modificationId).orElse(null);
        if (modification != null) {
            Component component = modification.getComponent();
            Requirement requirement = component.getRequirement();

            Fare fare = fareRepository.findFareValueByCompanyAndTechnologyAndAreaAndStatus(
                    requirement.getCompany(), requirement.getTechnology(), requirement.getArea(), new Status(55));

            requirement.setFareValue(fare != null ? fare.getFareValue() : new Double(0.0));
        }
        return modification;
    }

    @Override
    public List<Modification> findAllModifications() {
        return modificationRepository.findAll();
    }

    @Override
    public Modification updateModification(Modification modification) {
        return modificationRepository.saveAndFlush(modification);
    }

    @Override
    public boolean notExist(Integer modificationId) {
        return !modificationRepository.existsById(modificationId);
    }

    @Autowired
    public void setModificationRepository(ModificationRepository modificationRepository) {
        this.modificationRepository = modificationRepository;
    }

    @Autowired
    public void setFareRepository(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }
}
