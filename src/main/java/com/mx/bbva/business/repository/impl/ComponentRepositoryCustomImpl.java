package com.mx.bbva.business.repository.impl;

import com.mx.bbva.business.dto.ComponentUpdateDatesDTO;
import com.mx.bbva.business.entity.Component;
import com.mx.bbva.business.repository.ComponentRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    @Transactional
    public void updateDatesById(ComponentUpdateDatesDTO component) {
        try {
            Query query = entityManager.createQuery("UPDATE Component c " +
                    "SET c.componentPossibleDeliverDate = '" + component.getComponentPossibleDeliverDate() + "', " +
                    "c.componentPreviewDeliverDate = '" + component.getComponentPreviewDeliverDate() + "', " +
                    "c.componentDesignRealDeliverDate = '" + component.getComponentDesignRealDeliverDate() + "', " +
                    "c.componentRealDeliverDate = '" + component.getComponentRealDeliverDate() + "' " +
                    "WHERE c.componentId = '" + component.getComponentId() + "'");
            query.executeUpdate();
            entityManager.flush();
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
