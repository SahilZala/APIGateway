package com.pack.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pack.dao.User;
import com.pack.dto.UserDto;
import com.pack.service.UserService;

@Component
public class UserDtoImpl implements UserDto{

	@Autowired
	UserService userService;
	
	@Override
	public User createUser(User user) {
		return userService.createuser(user);
	}

	@Override
	public User getUserByEmailIdAndPassword(String emailId, String password) {
		return userService.getUserByEmailIdAndPassword(emailId,password);
				
	}

	@Override
	public User getUserByEmailId(String emailId) {
		return userService.getUserByEmailId(emailId);
	}
}
