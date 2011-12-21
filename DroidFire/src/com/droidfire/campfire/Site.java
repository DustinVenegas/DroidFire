package com.droidfire.campfire;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;

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
	
	public String login(String userName, String password) {
		Request request = new Request(userName, password);
		Response response = request.getResponse(URI.create(mSite.toString() + "/users/me.json"));
		
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
	
	public URI getSite() {
		return mSite;
	}
}
