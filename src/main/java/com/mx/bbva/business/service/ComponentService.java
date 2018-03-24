package com.mx.bbva.business.service;

import com.mx.bbva.business.model.Component;

import java.util.List;

public interface ComponentService {
    void saveComponent(Component component);

    Component findComponent(Integer componentId);

    List<Component> findAllComponents();
}
