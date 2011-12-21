package com.droidfire.campfire;

import org.json.JSONObject;

public class Response {
	
	private JSONObject mData;
	private int mStatus;
	
	public Response(JSONObject data, int status) {
		mData = data;
		mStatus = status;
	}
	
	public JSONObject getData() {
		return mData;
	}
	
	public int getStatus() {
		return mStatus;
	}
}
