package com.magdiev.dao;

import com.magdiev.models.User;

public interface UserDao {
    User findUserByUsername(String username);
    User findUserById(int id);
    void add(User user);
}
