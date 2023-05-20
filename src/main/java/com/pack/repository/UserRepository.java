package com.pack.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pack.dao.User;

@FeignClient("USER-SERVICE")
public interface UserRepository {
	
	@PostMapping("/user_microservice/user/create")
	User createNewUser(@RequestBody User u); 
	
	@GetMapping("/user_microservice/user/get_by_email_id/{emailId}")
	User getUserByEmailId(@PathVariable String emailId);
}
