package com.pack.filter;

import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

public class GatewayFilter extends AbstractGatewayFilterFactory<GatewayFilter.Config>{
	
	@Override
	public org.springframework.cloud.gateway.filter.GatewayFilter apply(Config config) {
		return null;
	}

	public static class Config{
		
	}
}
