package com.agiletdd.application.domain;

import java.util.List;

public interface UserRepository  {
	
	List<User> findAll();
	
	User save(User user);

	User findByName(String name);
}
