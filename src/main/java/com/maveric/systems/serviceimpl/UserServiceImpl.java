package com.maveric.systems.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maveric.systems.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public List<String> getUserDetails() {
		List<String> userList = List.of("Alok", "Ranjan");
		return userList;
	}
}
