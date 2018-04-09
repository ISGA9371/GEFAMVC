package com.mx.bbva.business.repository;

import com.mx.bbva.business.entity.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FareRepository extends JpaRepository<Fare, Integer> {
    @Query(value = "SELECT NEW com.mx.bbva.business.entity.Fare(f.fareId, f.fareValue) FROM Fare f WHERE f.company.companyId = :companyId AND f.technology.technologyId = :technologyId AND f.area.areaId = :areaId AND f.status.statusId = 26 ")
    Fare findCurrentCompanyFareByTechnologyAndArea(@Param(value = "companyId") Integer companyId, @Param(value = "technologyId") Integer technologyId, @Param(value = "areaId") Integer areaId);
}
