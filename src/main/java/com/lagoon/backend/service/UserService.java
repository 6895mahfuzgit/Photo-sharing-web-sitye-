package com.lagoon.backend.service;


import com.lagoon.backend.model.User;

public interface UserService {

	User save(User user);

	User findByUserName(String userName);

}
