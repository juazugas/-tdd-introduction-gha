package com.agiletdd.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agiletdd.application.domain.User;
import com.agiletdd.application.domain.UserRepository;

@Service
@Transactional
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public DefaultUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(String name, String city) {
		User exists = userRepository.findByName(name);
		if (null!=exists) {
			throw new RuntimeException("duplicated name");
		}

		User user = new User(name,city);

		userRepository.save(user);

		return user;
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
