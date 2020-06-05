package com.magdiev.services;

import com.magdiev.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User findUserByUsername(String username);
   User findUserById(int id);
    void add(User user);
}
