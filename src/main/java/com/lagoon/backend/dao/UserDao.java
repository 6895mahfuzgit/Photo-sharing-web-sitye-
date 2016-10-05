package com.lagoon.backend.dao;

import com.lagoon.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao extends CrudRepository<User,Long> {

    User save(User user);

    User findByUserName(String userName);




}
