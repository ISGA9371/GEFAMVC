package com.bbva.bancomer.business.service;

import com.bbva.bancomer.business.model.Component;

import java.util.List;

public interface ComponentService {
    void saveComponent(Component component);

    Component findComponent(Integer componentId);

    List<Component> findAllComponents();
}
