package com.lagoon.backend.controller;

import com.lagoon.backend.model.User;
import com.lagoon.backend.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {

        return userService.save(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> json) throws ServletException {

        if (json.get("username") == null || json.get("password") == null) {
            throw new ServletException("Please Fill User Name and Password");

        }
        String userName = json.get("username");
        String password = json.get("password");


        System.out.println(userName + "<user  ********  passs>" + password);


        User user = userService.findByUserName(userName);


        if (user == null) {

            throw new ServletException("User name not found");
        }
        String passwd = user.getPassword();
        if (!password.equals(passwd)) {

            throw new ServletException("Invalid login. Please check your name and password");
        }


        return Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "bcbjdcbhhbcvnbvcbnfvnbsdhjhjdsjkdsjksdmdxncxcjxhcxhhfdhbndsbnsdghsaghsbedghdsghdsgvdsvbdsbv bvcx ghcx").compact();
    }


}

