package com.agiletdd.application.domain;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {

	List<User> users = new ArrayList();

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public User save(User user) {
		users.removeIf(userNode -> userNode.getId().equals(user.getId()));
		users.add(user);
		return user;
	}

	@Override
	public User findByName(String name) {
		return users.stream().filter(user -> name.equals(user.getName())).findFirst().orElse(null);
	}
}
