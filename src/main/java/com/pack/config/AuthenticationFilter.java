package com.pack.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.google.common.net.HttpHeaders;
import com.pack.dao.JWTRequest;
import com.pack.dao.User;
import com.pack.dto.UserDto;
import com.pack.exceptions.AuthenticationException;
import com.pack.exceptions.HeaderNotFoundException;
import com.pack.util.JWTUtil;
import com.pack.util.ProjectUtil;
import com.pack.util.RouterValidator;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	
	@Autowired
	private final RouterValidator routerValidator;
	private final JWTUtil jwtUtil;
	@Autowired
	private UserDto userDto;
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

	public static class Config{
		
	}

	public AuthenticationFilter(RouterValidator routerValidator, JWTUtil jwtUtil) {
		super(Config.class);
		this.routerValidator = routerValidator;
		this.jwtUtil = jwtUtil;
	}


	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange,chain)->{
			log.info("in authentication filter");
			log.info("request "+exchange.getRequest().getMethodValue());
			if(!routerValidator.isSecured.apply(exchange.getRequest())) {
				return chain.filter(exchange);
			}
			
			
			if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
			{	
				log.info("header is missing");
				throw new HeaderNotFoundException("authorization header is missing.");
			}
			String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			
			
			authHeader = authHeader.substring(7);	
			String userName = jwtUtil.extractUsername(authHeader);
			log.info(userName);
			User u = userDto.getUserByEmailId(userName);
			log.info(u.toString());
			
			if(!routerValidator.isAdmin.apply(exchange.getRequest()) && u.getUserType().equals(ProjectUtil.USER_ROLE))
			{
				throw new AuthenticationException("unauthorized exception : not valid user");
			}
			
			JWTRequest jwtRequest = new JWTRequest(u.getEmailId(),u.getPassword());
			log.info(jwtRequest.toString());
			if(Boolean.FALSE.equals(jwtUtil.validateToken(authHeader, jwtRequest)))
			{
				throw new AuthenticationException("unauthorized exception");
			}
			
			log.info("authorization successfully");
			return chain.filter(exchange);
		});
	}
	

}
