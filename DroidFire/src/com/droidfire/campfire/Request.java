package com.droidfire.campfire;

public class Request {
	
	private String token;
	
	public Request(String token) {
		this.token = token;
	}
	
	public Request(String username, String password) {
		//authenticate
		throw new UnsupportedOperationException();
	}
	
	public void post(Object data) {
		throw new UnsupportedOperationException();
	}
}
