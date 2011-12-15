package com.droidfire.campfire;

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
	
	public Room[] getRooms() {
		//Not yet implemented
		throw new UnsupportedOperationException();
	}
}
