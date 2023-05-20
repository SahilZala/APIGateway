package com.pack.dao;

public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", password=" + password + ", username=" + username
				+ ", userType=" + userType + ", activation=" + activation + "]";
	}
	private String id;
	private String emailId;
	private String password;
	private String username;
	private String userType;
	private boolean activation;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	public User(String id, String emailId, String password, String username, String userType, boolean activation) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.username = username;
		this.userType = userType;
		this.activation = activation;
	}
	public User() {
		super();
	}
	public User(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}
	
	
	
	
}
