package com.agiletdd.framework.restcontroller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agiletdd.application.domain.User;
import com.agiletdd.application.service.DefaultUserService;

@RestController
public class UserController {

	private DefaultUserService userService;

	@Autowired
	public UserController(DefaultUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/user")
	public User usersf(@RequestBody CreateUserRequest request) {
		User user = userService.createUser(request.name,request.city);

		return user;
	}

	@RequestMapping("/user")
	public List<User> user(Model model) {
		return userService.findAllUsers();
	}

	
}
