package com.francortiz.Shop.services.impl;

import com.francortiz.Shop.exceptions.UserNotFoundException;
import com.francortiz.Shop.models.User;
import com.francortiz.Shop.repositories.RoleRepository;
import com.francortiz.Shop.repositories.UserRepository;
import com.francortiz.Shop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User userUpdate, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario ingresado no existe"));
        return userRepository.save(userUpdate);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
