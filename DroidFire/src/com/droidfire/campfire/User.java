package com.droidfire.campfire;

import org.json.JSONObject;

public class User {
	private boolean mIsAdmin;
	private String mEmail;
	private int mId;
	private String mName;
	private String mToken;
	
	public boolean isAdmin() {
		return mIsAdmin;
	}
	
	public String getEmail() {
		return mEmail;
	}
	
	public int getId() {
		return mId;
	}
	
	public String getName() {
		return mName;
	}
	
	public String getToken() {
		return mToken;
	}
	
	public static User serializeFromJson(JSONObject object) {
		throw new UnsupportedOperationException();
	}
}
