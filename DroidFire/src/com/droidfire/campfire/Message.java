package com.droidfire.campfire;

import org.json.JSONObject;

public abstract class Message {
	
	protected int mId;
	protected int mRoomId;
	protected int mUserId;
	protected String mBody;
	
	public int getId() {
		return mId;
	}
	
	public abstract JSONObject toJSONObject();
	
}
