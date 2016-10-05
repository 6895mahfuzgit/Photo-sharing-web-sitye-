package com.lagoon.backend.controller;

import com.lagoon.backend.model.User;
import com.lagoon.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MahfuzCSE'11 on 01-Oct-16.
 */

@RestController
@RequestMapping("/rest")
public class UserResourcesController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/users")
    public String loginsuccess() {

        return "Login Successfully";
    }


    @RequestMapping(value = "user/userName", method = RequestMethod.POST)
    public User findByUserName(@RequestBody String userName) {

        return userService.findByUserName(userName);
    }
///user/update


    @RequestMapping(value = "user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {

        return userService.save(user);
    }

}
