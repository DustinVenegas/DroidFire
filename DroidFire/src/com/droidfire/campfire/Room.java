package com.droidfire.campfire;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Room {
	
	private String mToken;
	private Site mSite;
	
	private boolean mHasJoined;
	private int mId;
	private String mName;
	private String mTopic;
	
	private List<User> mUsers;
		
	public Room(int id, String name, String topic, List<User> users) {
		mId = id;
		mName = name;
		mTopic = topic;
		mUsers = users;
	}
	
	public int getId() {
		return mId;
	}
	
	public String getName() {
		return mName;
	}
	
	public List<Message> getMessages() {
		throw new UnsupportedOperationException();
	}
	
	public String getTopic() {
		return mTopic;
	}
	
	public List<User> getUsers() {
		return mUsers;
	}
	
	/**
	 * Attempts to join this room. If successful returns true, otherwise false.	 * 
	 */
	public boolean join() {
		Response response = new Request(mToken).post(URI.create(mSite.getSite() + "/room/" + mId + "/join.json"));
		if (response.getStatus() == 200) {
			mHasJoined = true;
			return true;
		} else {
			return false;
		}
	}
	
	void setToken(String token) {
		mToken = token;
	}
		
	public void speak(Message message) {
		if (mHasJoined) {
			Response response = new Request(mToken).post(URI.create(mSite.getSite() + "/room" + mId + "/speak.json"), message.toJSONObject());
			throw new UnsupportedOperationException();
		} else {
			throw new IllegalStateException("Must join the room before being able to speak.");
		}		
	}
	
	static Room serializeFromJson(JSONObject object) throws JSONException {
		if (object.has("room")) {
			object = object.getJSONObject("room");
		}
		
		int id = object.getInt("id");
		String name = object.getString("name");
		String topic = object.getString("topic");
		List<User> users = null;
		if (object.has("users")) {
			JSONArray usersJson = object.getJSONArray("users");
			users = new ArrayList<User>();
			for(int i = 0; i < usersJson.length(); i++) {
				users.add(User.serializeFromJson(usersJson.getJSONObject(i)));
			}
		}
		
		return new Room(id, name, topic, users);
	}
}
