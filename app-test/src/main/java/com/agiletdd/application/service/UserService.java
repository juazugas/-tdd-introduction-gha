package com.agiletdd.application.service;

import java.util.List;

import com.agiletdd.application.domain.User;

public interface UserService {
	User createUser(String name, String city);

	List<User> findAllUsers();
}
