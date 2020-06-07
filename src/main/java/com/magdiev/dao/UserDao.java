package com.magdiev.dao;

import com.magdiev.models.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);
    User findUserById(int id);
    void add(User user);
    String getCurrentUsername();
    List<User> getUserList();
}
