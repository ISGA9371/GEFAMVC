package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.dto.ComponentClosureDTO;
import com.mx.bbva.business.dto.ComponentUpdateDatesDTO;
import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.repository.ComponentRepository;
import com.mx.bbva.business.repository.DoubtRepository;
import com.mx.bbva.business.repository.IssueRepository;
import com.mx.bbva.business.repository.ModificationRepository;
import com.mx.bbva.business.service.ComponentService;
import com.mx.bbva.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {
    private ComponentRepository componentRepository;
    private IssueRepository issueRepository;
    private ModificationRepository modificationRepository;
    private DoubtRepository doubtRepository;

    @Override
    public Component saveComponent(Component component) {
        if (component.getComponentId() == null) {
            component.setComponentForBill(false);
            component.setComponentUploadDate(new DateUtils().getCurrentDate());
        }
        return componentRepository.saveAndFlush(component);
    }

    @Override
    public List<Component> findByCustomQuery(String query) {
        return componentRepository.findByCustomQuery(query);
    }

    @Override
    public Component findComponent(Integer componentId) {
        return componentRepository.findById(componentId).orElse(null);
    }

    @Override
    public List<Component> findAllComponents() {
        return componentRepository.findAll();
    }

    @Override
    public void deleteComponent(Integer componentId) {
        componentRepository.deleteById(componentId);
    }

    @Override
    public void updateDates(List<ComponentUpdateDatesDTO> components) {
        for (ComponentUpdateDatesDTO component : components) {
            if (component.getComponentIds() != null) {
                componentRepository.updateAllDates(component);
                break;
            } else {
                componentRepository.updateDatesById(component);
            }
        }
    }

    @Override
    public void updateClosureComponent(List<ComponentClosureDTO> components) {
        for (ComponentClosureDTO component : components) {
            componentRepository.updateClosureById(component);
        }
    }

    @Override
    public boolean notRemovable(Integer componentId) {
        return issueRepository.existsByComponent_ComponentId(componentId)
                || modificationRepository.existsByComponent_ComponentId(componentId)
                || doubtRepository.existsByComponent_ComponentId(componentId);
    }

    @Autowired
    public void setComponentRepository(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Autowired
    public void setIssueRepository(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Autowired
    public void setModificationRepository(ModificationRepository modificationRepository) {
        this.modificationRepository = modificationRepository;
    }

    @Autowired
    public void setDoubtRepository(DoubtRepository doubtRepository) {
        this.doubtRepository = doubtRepository;
    }
}
