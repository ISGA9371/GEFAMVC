package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.ProfileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileTypeRepository extends JpaRepository<ProfileType, Integer> {

}
