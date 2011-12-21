package com.droidfire.test;

import java.net.URI;
import java.util.List;

import android.util.Log;

import com.droidfire.campfire.Room;
import com.droidfire.campfire.Site;

import junit.framework.TestCase;

public class SiteTest extends TestCase {

	public SiteTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testLogin() {
		Site site = new Site(URI.create("https://sample.campfirenow.com"));
		String response = site.login("", "");
		assertTrue(response != null);
		
		Log.i("response token", response);
	}
	
	public final void testGetRooms() {
		Site site = new Site(URI.create("https://sample.campfirenow.com"));
		String token = site.login("", "");
		assertTrue(token != null);
		
		List<Room> rooms = site.getRooms();
		assertTrue(rooms != null);
		assertTrue(rooms.size() > 0);
		
		Log.i("first room id", rooms.get(0).getId() + "");
		
	}

}
