package com.pack.dao;

public class Response {
	
	@Override
	public String toString() {
		return "Response [stausCode=" + stausCode + ", message=" + message + ", body=" + body + "]";
	}
	public int getStausCode() {
		return stausCode;
	}
	public void setStausCode(int stausCode) {
		this.stausCode = stausCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	private int stausCode;
	private String message;
	private Object body;
	public Response(int stausCode, String message, Object body) {
		super();
		this.stausCode = stausCode;
		this.message = message;
		this.body = body;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
