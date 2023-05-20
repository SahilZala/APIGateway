package com.pack.service;

import com.pack.dao.User;

public interface UserService {
	User createuser(User user);
	User getUserByEmailIdAndPassword(String emailId,String password);
	User getUserByEmailId(String emailId);
}
