package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Component;
import com.bbva.bancomer.business.repository.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {
    @Autowired
    private ComponentRepository componentRepository;

    @Override
    public void saveComponent(Component component) {
        componentRepository.save(component);
    }

    @Override
    public Component findComponent(Integer componentId) {
        return componentRepository.findById(componentId).get();
    }

    @Override
    public List<Component> findAllComponents() {
        return componentRepository.findAll();
    }

    public void setComponentRepository(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }
}
