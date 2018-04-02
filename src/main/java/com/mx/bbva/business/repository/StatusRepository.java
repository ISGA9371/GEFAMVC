package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Status;
import com.mx.bbva.business.entity.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    List<Status> findByStatusType(StatusType statusType);
}
