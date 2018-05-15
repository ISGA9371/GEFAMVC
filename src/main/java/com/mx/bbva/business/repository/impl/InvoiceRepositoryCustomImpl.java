package com.mx.bbva.business.repository.impl;

import com.mx.bbva.business.entity.Invoice;
import com.mx.bbva.business.repository.InvoiceRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class InvoiceRepositoryCustomImpl implements InvoiceRepositoryCustom {

    private EntityManager entityManager;

    @Override
    public List<Invoice> findByCustomQuery(String query) {
        try {
            TypedQuery<Invoice> typedQuery = entityManager.createQuery(query, Invoice.class);
            return typedQuery.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
