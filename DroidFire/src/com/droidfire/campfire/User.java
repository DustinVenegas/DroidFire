package com.droidfire.campfire;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
	private boolean mIsAdmin;
	private String mEmail;
	private int mId;
	private String mName;
	private String mToken;
	
	public User(boolean isAdmin, String email, int id, String name, String token) {
		mIsAdmin = isAdmin;
		mEmail = email;
		mId = id;
		mName = name;
		mToken = token;
	}
	
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
	
	static User serializeFromJson(JSONObject object) throws JSONException {
		JSONObject userJson = object.getJSONObject("user");
		
		int id = userJson.getInt("id");
		String name = userJson.getString("name");
		String email = userJson.getString("email_address");
		boolean isAdmin = userJson.getBoolean("admin");
		String token = userJson.getString("api_auth_token");
		
		return new User(isAdmin, email, id, name, token);
	}
}
