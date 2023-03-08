package com.francortiz.Shop.services.impl;

import com.francortiz.Shop.models.User;
import com.francortiz.Shop.repositories.UserRepository;
import com.francortiz.Shop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
