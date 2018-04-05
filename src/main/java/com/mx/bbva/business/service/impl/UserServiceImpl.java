package com.mx.bbva.business.service.impl;

import com.mx.bbva.business.entity.User;
import com.mx.bbva.business.repository.UserRepository;
import com.mx.bbva.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User findUserByInternalId(String userInternalId) {
        return userRepository.findByUserInternalId(userInternalId);
    }

    @Override
    public List<User> findUsersByType(Integer profileTypeId) {
        return userRepository.findByProfileType_profileTypeId(profileTypeId);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
