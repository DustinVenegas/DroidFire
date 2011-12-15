package com.droidfire.campfire;

public class Room {
	
	private int mId;
	private String mName;
	private String mTopic;
		
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
}
