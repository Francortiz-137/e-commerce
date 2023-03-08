package com.francortiz.Shop.services;

import com.francortiz.Shop.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);
}
