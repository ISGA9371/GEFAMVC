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

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
