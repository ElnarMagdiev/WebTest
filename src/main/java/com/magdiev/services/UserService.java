package com.magdiev.services;

import com.magdiev.models.Result;
import com.magdiev.models.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);
    User findUserById(int id);
    void add(User user);
    String getCurrentUsername();
    List<User> getUserList();

}
