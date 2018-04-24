package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.Component;

import java.util.List;

public interface ComponentService {
    Component saveComponent(Component component);

    List<Component> findByCustomQuery(String query);

    Component findComponent(Integer componentId);

    List<Component> findAllComponents();

    void deleteComponent(Integer componentId);

    void updateDates(List<Component> components);
}
