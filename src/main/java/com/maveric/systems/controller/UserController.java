package com.maveric.systems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.systems.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping("/users")
	public ResponseEntity<?> getUserDetails() {
		List<String> userList = userService.getUserDetails();
		return ResponseEntity.ok(userList);
	}

}
