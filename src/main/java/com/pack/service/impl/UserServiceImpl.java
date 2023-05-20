package com.pack.service.impl;

import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pack.dao.Response;
import com.pack.dao.User;
import com.pack.exceptions.AuthenticationException;
import com.pack.exceptions.UserNotFoundException;
import com.pack.service.UserService;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public User createuser(User user) {
		return null;
	}

	@Override
	public User getUserByEmailIdAndPassword(String emailId,String password) {
			log.info("getUserByEmailIdAndPassword method call");
			
			ResponseEntity<Response> res = restTemplate
					.getForEntity(
					"http://localhost:8082/user_microservice/user/get_by_email_id_and_password?emailId="+emailId+"&password="+password,Response.class);
			
			if(res.getBody() == null)
				throw new NullPointerException("user not found");
			if(res.getStatusCode().value() == HttpStatus.UNAUTHORIZED.value())
				throw new AuthenticationException("unauthorized exception");
			return getObjectToUser(res.getBody().getBody());
		
	}
	
	@Override
	public User getUserByEmailId(String emailId) {
			log.info("getUserByEmailId method call");
			Response res = restTemplate.getForObject(
					"http://localhost:8082/user_microservice//user/get_by_email_id/"+emailId,Response.class);
			if(res == null)
				throw new NullPointerException("user not found");
			if(res.getStausCode() == HttpStatus.UNAUTHORIZED.value())
				throw new UserNotFoundException("user not found");
			return getObjectToUser(res.getBody());
	}
	
	private User getObjectToUser(Object object) {
		@SuppressWarnings("unchecked")
		LinkedHashMap<String,Object> data = (LinkedHashMap<String, Object>)object;
		return new User(data.get("id").toString(),
				data.get("emailId").toString(),
				data.get("password").toString(),
				data.get("username").toString(),
				data.get("userType").toString(),
				Boolean.parseBoolean("activation")
			);
	}
	
}




