package com.droidfire.campfire;

import java.net.URI;
import java.util.List;

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
		Response response = request.getResponse(URI.create(mSite.toString() + "/users/me.json"));

		String token = null;
		if (response.getData() != null) {
			User user = User.serializeFromJson(response.getData());
			token = user.getToken();
		}
		
		return token;
	}
	
	public Room getRoom(int id) {
		//Not yet implemented
		throw new UnsupportedOperationException(); 
	}
	
	public List<Room> getRooms() {
		//Not yet implemented
		throw new UnsupportedOperationException();
	}
	
	public URI getSite() {
		return mSite;
	}
}
