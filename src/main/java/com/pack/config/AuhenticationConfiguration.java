package com.pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import com.pack.exceptions.ResponseErrorHandler;

@SuppressWarnings("deprecation")
@Configuration
public class AuhenticationConfiguration {
	
	
	@Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	
	
	
	@Bean
	public RestTemplate getResTemplate()
	{
		RestTemplate tem = new RestTemplate();
		tem.setErrorHandler(new ResponseErrorHandler());
		return tem;
	}
	
	
}
