package com.droidfire.campfire;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class Site {
	
	private URI mSite;
	private String mToken;
	
	public Site(URI site) {
		mSite = site;
	}
	
	public Site(URI site, String token) {
		mSite = site;
		mToken = token;
	}
	
	/**
	 * Attempts to log the user into the current site with the given username and password.
	 * If successful this method returns the auth token associated with the user, otherwise
	 * it will return null indicating that a failure of some kind occurred.
	 * 
	 * @param userName	The username used to log into campfire
	 * @param password	The password used to log into campfire
	 * @return 			The api token associated with the user if successful, otherwise null
	 */
	public String login(String userName, String password) {
		Request request = new Request(userName, password);
		Response response = request.get(URI.create(mSite.toString() + "/users/me.json"));

		mToken = null;
		if (response.getData() != null) {
			try {
				User user = User.serializeFromJson(response.getData());			
				mToken = user.getToken();
			} catch(JSONException ex) {
				ex.printStackTrace();
			}
		}
		
		return mToken;
	}
	
	public Room getRoom(int id) {
		Room room = null;
		
		Response response = new Request(mToken).get(URI.create(mSite.toString() + "/rooms/" + id + ".json"));
		if (response.getData() != null) {
			try {
				room = Room.serializeFromJson(response.getData());
				room.setToken(mToken);
				room.setSite(this);
			} catch(JSONException ex) {
				ex.printStackTrace();
			}
		}
		
		return room;
	}
	
	public List<Room> getRooms() {
		List<Room> rooms = null;
		
		Response response = new Request(mToken).get(URI.create(mSite.toString() + "/rooms.json"));
		if (response.getData() != null) {
			try {
				rooms = new ArrayList<Room>();
				JSONArray roomsJson = response.getData().getJSONArray("rooms");
				for(int i = 0; i < roomsJson.length(); i++) {
					Room room = Room.serializeFromJson(roomsJson.getJSONObject(i));
					room.setToken(mToken);
					room.setSite(this);
					rooms.add(room);
				}
			} catch(JSONException ex) {
				ex.printStackTrace();
			}
		}
		
		return rooms;
	}
	
	public URI getSite() {
		return mSite;
	}
}
