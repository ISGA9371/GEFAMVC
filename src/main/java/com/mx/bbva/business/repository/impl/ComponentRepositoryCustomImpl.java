package com.mx.bbva.business.repository.impl;

import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.repository.ComponentRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ComponentRepositoryCustomImpl implements ComponentRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Component> findByCustomQuery(String query) {
        try {
            TypedQuery<Component> typedQuery = entityManager.createQuery(query, Component.class);
            return typedQuery.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void updateDatesById(Component component) {
        try {
            entityManager.createQuery("UPDATE Component c SET c.componentPossibleDeliverDate = :possibleDeliverDate, " +
                    "c.componentPreviewDeliverDate = :previewDeliverDate, c.componentDesignRealDeliverDate = :designRealDeliverDate, " +
                    "c.componentRealDeliverDate = :realDeliverDate WHERE c.componentId = :componentId", Component.class)
                    .setParameter("possibleDeliverDate", component.getComponentPossibleDeliverDate())
                    .setParameter("previewDeliverDate", component.getComponentPreviewDeliverDate())
                    .setParameter("designRealDeliverDate", component.getComponentDesignRealDeliverDate())
                    .setParameter("realDeliverDate", component.getComponentRealDeliverDate())
                    .setParameter("componentId", component.getComponentId())
                    .executeUpdate();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
