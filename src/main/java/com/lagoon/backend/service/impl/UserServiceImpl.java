package com.lagoon.backend.service.impl;

import com.lagoon.backend.dao.UserDao;
import com.lagoon.backend.model.User;
import com.lagoon.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    public User save(User user) {

        return userDao.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }


}
