package com.agiletdd.application.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agiletdd.application.domain.InMemoryUserRepository;
import com.agiletdd.application.domain.User;
import com.agiletdd.application.domain.UserRepository;

import java.util.List;

public class DefaultUserServiceTest {

	DefaultUserService userService;
	UserRepository userRepository;
	
	@Before
	public void setUp() throws Exception {
		userRepository = new InMemoryUserRepository();
		userService = new DefaultUserService(userRepository);
	}

	@Test
	public void should_create_new_users() {
		userService.createUser("foo",null);
		
		User createdUser = userRepository.findAll().get(0);
		
		assertEquals("foo", createdUser.getName());
		assertNull(createdUser.getCity());
	}

	@Test
	public void should_create_new_users_with_city() {
		userService.createUser("foo", "city");

		User createdUser = userRepository.findAll().get(0);

		assertEquals("foo", createdUser.getName());
		assertEquals("city", createdUser.getCity());
		assertThat(createdUser, hasProperty("city", equalTo("city")));
	}

	@Test(expected = RuntimeException.class)
	public void should_not_create_user_with_other_user_existing_name() {
		userService.createUser("foo",null);
		userService.createUser("foo",null);
	}

	@Test
	public void should_list_all_users() {
		List<User> result = null;
		_given:{
			userService.createUser("foo",null);
			userService.createUser("fabian",null);
		}

		_when: {
			result = userService.findAllUsers();
		}

		_then: {
			assertNotNull(result);
			assertThat(result, hasSize(2));
			assertThat(result, allOf(
					hasItem(hasProperty("name", equalTo("foo"))),
					hasItem(hasProperty("name", equalTo("fabian")))
			));
		}
	}


}
