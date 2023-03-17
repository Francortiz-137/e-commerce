package com.francortiz.Shop.services;

import com.francortiz.Shop.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(User user, Long id);

    void deleteById(Long id);
}
