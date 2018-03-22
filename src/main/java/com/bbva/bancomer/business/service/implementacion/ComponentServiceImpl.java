package com.bbva.bancomer.business.service.implementacion;

import com.bbva.bancomer.business.model.Component;
import com.bbva.bancomer.business.model.Component_;
import com.bbva.bancomer.business.repository.ComponentRepository;
import com.bbva.bancomer.business.service.ComponentService;
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
        return componentRepository.findById(componentId).orElse(null);
    }

    @Override
    public List<Component> findAllComponents() {
        return componentRepository.findAll();
    }

    public void setComponentRepository(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }
}
