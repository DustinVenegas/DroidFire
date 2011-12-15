package com.droidfire.campfire;

public class Site {
	
	private String mToken;
	
	public Site() {
		
	}
	
	public Site(String token) {
		mToken = token;
	}
	
	public String login(String userName, String password) {
		throw new UnsupportedOperationException();
	}
	
	public Room getRoom(int id) {
		//Not yet implemented
		throw new UnsupportedOperationException(); 
	}
	
	public Room[] getRooms() {
		//Not yet implemented
		throw new UnsupportedOperationException();
	}
}
