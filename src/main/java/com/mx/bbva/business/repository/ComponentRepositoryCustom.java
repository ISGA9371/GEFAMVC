package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Component;

import java.util.List;

public interface ComponentRepositoryCustom {
    List<Component> findByCustomQuery(String query);

    void updateDatesById(Component component);
}
