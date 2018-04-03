package com.mx.bbva.business.repository.impl;

import com.mx.bbva.business.entity.Requirement;
import com.mx.bbva.business.repository.RequirementRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RequirementRepositoryCustomImpl implements RequirementRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Requirement> findByCustomQuery(String query) {
        try {
            TypedQuery<Requirement> typedQuery = entityManager.createQuery(query, Requirement.class);
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
