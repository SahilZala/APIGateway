package com.pack.dto;

import com.pack.dao.User;

public interface UserDto {
	User createUser(User user);
	User getUserByEmailIdAndPassword(String emailId,String password);
	User getUserByEmailId(String emailId);
}
