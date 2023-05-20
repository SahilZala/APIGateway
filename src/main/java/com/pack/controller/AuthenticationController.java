package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dao.JWTRequest;
import com.pack.dao.JWTResponse;
import com.pack.dto.UserDto;
import com.pack.service.UserService;
import com.pack.util.JWTUtil;

@RestController
@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	UserDto userDto;
	@Autowired
	UserService userService;
	
	@PostMapping("/token")
	public ResponseEntity<JWTResponse> token(@RequestBody JWTRequest req)
	{
		if(userDto.getUserByEmailIdAndPassword(req.getUserName(),req.getPassword()) != null)
		{
			String token = jwtUtil.generateToken(req);
			return new ResponseEntity<>(new JWTResponse(token),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new JWTResponse(null),HttpStatus.OK);
		}
	}
	
	@GetMapping("/index")
	public String index()
	{
		return "index";
	}
	
	
}
