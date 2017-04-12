package com.agiletdd.application.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.agiletdd.application.domain.InvalidUserParameterException;
import com.agiletdd.application.domain.User;

public class UserTest {

	@Test
	public void should_be_created_with_valid_parameters() {
		User user = new User("foo","Valencia");

		assertEquals("foo", user.getName());
		assertNotNull(user.getId());
		assertNotNull(user.getCity());
		assertNotNull(user.getCreationInstant());
	}
	
	@Test(expected=InvalidUserParameterException.class)
	public void try_create_user_with_short_name() {
		new User("fo","Sity");
	}

}
