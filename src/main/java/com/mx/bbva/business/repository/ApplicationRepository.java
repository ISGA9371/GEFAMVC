package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.Application;
import com.mx.bbva.business.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByTechnology(Technology technology);
}
