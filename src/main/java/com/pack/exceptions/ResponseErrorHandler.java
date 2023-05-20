package com.pack.exceptions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;

public class ResponseErrorHandler implements org.springframework.web.client.ResponseErrorHandler  {

	
	private static final Logger log = LoggerFactory.getLogger(ResponseErrorHandler.class);

	
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		
		return true;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		log.info("sasa"+response.getRawStatusCode());
	}

}
