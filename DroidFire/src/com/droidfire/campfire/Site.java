package com.droidfire.campfire;

import java.util.List;

import android.net.Uri;

public class Site {
	
	private Uri mSite;
	
	public Site(Uri site) {
		mSite = site;
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
}
