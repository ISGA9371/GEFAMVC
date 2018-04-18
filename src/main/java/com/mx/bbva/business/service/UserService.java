package com.mx.bbva.business.service;

import com.mx.bbva.business.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findUser(String userId);

    User findUserByInternalId(String userInternalId);

    List<User> findUsersByType(Integer profileTypeId);

    List<User> findAllUsers();

    User findUserByIdAndType(String userInternalId, Integer profileTypeId);
}
