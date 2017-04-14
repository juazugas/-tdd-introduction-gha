package com.agiletdd.application.service;

import com.agiletdd.application.domain.User;

import java.util.List;

public interface UserService {
    User createUser(String name, String city);

    List<User> findAllUsers();
}
