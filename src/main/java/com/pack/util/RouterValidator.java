package com.pack.util;

import java.util.List;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import com.google.common.base.Predicate;

@Component
public class RouterValidator {
	public static final List<String> openApiEndpoints = List.of(
			"/user_microservice/user/create");
	
	public static final List<String> adminApiEndpoints = List.of("/movie/admin/create");
	
	public Predicate<ServerHttpRequest> isSecured = 
			request -> openApiEndpoints
			.stream()
			.noneMatch(uri->request.getURI().getPath().contains(uri));
			
	public Predicate<ServerHttpRequest> isAdmin = 
			request->adminApiEndpoints
			.stream()
			.noneMatch(uri->request.getURI().getPath().contains(uri));
}
