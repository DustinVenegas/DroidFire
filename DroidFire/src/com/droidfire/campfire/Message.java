package com.droidfire.campfire;

import org.json.JSONObject;

public abstract class Message {
	
	private int mId;
	private int mRoomId;
	private int mUserId;
	private String mBody;
	
	public int getId() {
		return mId;
	}
	
	public abstract JSONObject toJSONObject();
	
}
