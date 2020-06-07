package com.magdiev.services.impl;

import com.magdiev.dao.UserDao;
import com.magdiev.models.Result;
import com.magdiev.models.User;
import com.magdiev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@EnableTransactionManagement
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    @Transactional
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public String getCurrentUsername() {
        return userDao.getCurrentUsername();
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }


}
