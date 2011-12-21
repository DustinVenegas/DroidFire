package com.droidfire.campfire;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Room {
	
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
	
	public String getTopic() {
		return mTopic;
	}
	
	public List<User> getUsers() {
		return mUsers;
	}
	
	public void join() {
		//Not yet implemented
		throw new UnsupportedOperationException();
	}
	
	public void speak(Message message) {
		//Not yet implemented
		throw new UnsupportedOperationException();
	}
	
	static Room serializeFromJson(JSONObject object) throws JSONException {
		JSONObject roomJson = object.getJSONObject("room");
		int id = roomJson.getInt("id");
		String name = roomJson.getString("name");
		String topic = roomJson.getString("topic");
		List<User> users = null;
		if (roomJson.has("users")) {
			JSONArray usersJson = roomJson.getJSONArray("users");
			users = new ArrayList<User>();
			for(int i = 0; i < usersJson.length(); i++) {
				users.add(User.serializeFromJson(usersJson.getJSONObject(i)));
			}
		}
		
		return new Room(id, name, topic, users);
	}
}
