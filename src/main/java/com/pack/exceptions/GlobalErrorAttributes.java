package com.pack.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes{
    
	private static final Logger log = LoggerFactory.getLogger(GlobalErrorAttributes.class);

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, 
      ErrorAttributeOptions options) {
    	log.info("in handler");
    	

        Map<String, Object> map = new HashMap<>();
        map.put("status", HttpStatus.BAD_REQUEST.value());
        map.put("message",super.getError(request).getMessage());
        map.put("body",null);
        return map;
    }

}