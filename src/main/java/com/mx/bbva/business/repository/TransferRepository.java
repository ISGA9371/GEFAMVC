package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Budget;
import com.mx.bbva.business.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {
    List<Transfer> findByBudgetDb(Budget budget);
}
