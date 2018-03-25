package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.repository.ComponentRepository;
import com.mx.bbva.business.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {
    private ComponentRepository componentRepository;

    @Override
    public void saveComponent(Component component) {
        componentRepository.save(component);
    }

    @Override
    public Component findComponent(Integer componentId) {
        return componentRepository.findById(componentId).orElse(null);
    }

    @Override
    public List<Component> findAllComponents() {
        return componentRepository.findAll();
    }

    @Autowired
    public void setComponentRepository(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }
}
