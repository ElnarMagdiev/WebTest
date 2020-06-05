package com.magdiev.services;

import com.magdiev.models.User;

public interface UserService {
    User findUserByUsername(String username);
   User findUserById(int id);
    void add(User user);
}
