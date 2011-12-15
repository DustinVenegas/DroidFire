package com.droidfire.campfire;

import java.util.List;

import android.net.Uri;

public class Site {
	
	private Uri mSite;
	private String mToken;
	
	public Site(Uri site) {
		mSite = site;
	}
	
	public Site(Uri site, String token) {
		mSite = site;
		mToken = token;
	}
	
	public String login(String userName, String password) {
		throw new UnsupportedOperationException();
	}
	
	public Room getRoom(int id) {
		//Not yet implemented
		throw new UnsupportedOperationException(); 
	}
	
	public List<Room> getRooms() {
		//Not yet implemented
		throw new UnsupportedOperationException();
	}
	
	public Uri getSite() {
		return mSite;
	}
}
