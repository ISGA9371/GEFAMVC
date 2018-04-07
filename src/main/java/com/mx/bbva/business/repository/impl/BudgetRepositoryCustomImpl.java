package com.mx.bbva.business.repository.impl;

import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.repository.BudgetRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BudgetRepositoryCustomImpl implements BudgetRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Budget> findByCustomQuery(String query) {
        try {
            TypedQuery<Budget> typedQuery = entityManager.createQuery(query, Budget.class);
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
