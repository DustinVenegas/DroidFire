package com.droidfire.campfire;

import java.util.List;

public class Room {
	
	private int mId;
	private String mName;
	private String mTopic;
	
	private List<User> mUsers;
		
	Room(String token) {
		
	}
	
	public int getId() {
		return mId;
	}
	
	public String getName() {
		return mName;
	}
	
	public String getTopic() {
		return mTopic;
	}
	
	public List<User> getUsers() {
		return mUsers;
	}
}
