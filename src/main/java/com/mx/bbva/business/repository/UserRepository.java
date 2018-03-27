package com.mx.bbva.business.repository;


import com.mx.bbva.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserInternalId(String userInternalId);

    List<User> findByProfileType_profileTypeId(Integer profileTypeId);
}
