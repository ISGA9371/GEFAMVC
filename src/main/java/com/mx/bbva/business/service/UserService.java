package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findUser(Integer userId);

    User findUserByInternalId(String userInternalId);

    List<User> findUsersByType(Integer profileTypeId);

    List<User> findUsersByLevel(Integer levelId);

    List<User> findAllUsers();
}
