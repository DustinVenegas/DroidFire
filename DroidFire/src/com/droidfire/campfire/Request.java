package com.droidfire.campfire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

class Request {
	
	private String token;
	
	private String mUsername;
	private String mPassword;
	
	public Request(String token) {
		this.token = token;
	}
	
	public Request(String username, String password) {
		mUsername = username;
		mPassword = password;
	}
	
	public Response get(URI target) {
		HttpHost targetHost = new HttpHost(target.getHost(), target.getPort(), target.getScheme());
		DefaultHttpClient client = new DefaultHttpClient();
		if (token == null || token.equals("")) {
			client.getCredentialsProvider().setCredentials(
					new AuthScope(targetHost.getHostName(), targetHost.getPort()), 
					new UsernamePasswordCredentials(mUsername, mPassword));
		} else {
			client.getCredentialsProvider().setCredentials(
					new AuthScope(targetHost.getHostName(), targetHost.getPort()), 
					new UsernamePasswordCredentials(token, "X"));
		}
		HttpGet request = new HttpGet(target);
		
		Response result = null;
		try {
			HttpResponse httpResponse = client.execute(targetHost, request);
			JSONObject data = serializeToJson(httpResponse.getEntity());
			result = new Response(data, httpResponse.getStatusLine().getStatusCode());
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}

		return result;
	}
	
	public Response post(URI target) {
		return this.post(target, new JSONObject());
	}

	public Response post(URI target, JSONObject json) {
		HttpHost targetHost = new HttpHost(target.getHost(), target.getPort(), target.getScheme());
		DefaultHttpClient client = new DefaultHttpClient();
		if (token == null || token.equals("")) {
			client.getCredentialsProvider().setCredentials(
					new AuthScope(targetHost.getHostName(), targetHost.getPort()), 
					new UsernamePasswordCredentials(mUsername, mPassword));
		} else {
			client.getCredentialsProvider().setCredentials(
					new AuthScope(targetHost.getHostName(), targetHost.getPort()), 
					new UsernamePasswordCredentials(token, "X"));
		}
		
		Response result = null;
		try {
			HttpPost request = new HttpPost(target);
			request.setHeader("Content-Type", "application/json");
			StringEntity entity = new StringEntity(json.toString());
			entity.setContentType("text/json");
			request.setEntity(entity);
			
			HttpResponse httpResponse = client.execute(targetHost, request);
			JSONObject data = serializeToJson(httpResponse.getEntity());
			result = new Response(data, httpResponse.getStatusLine().getStatusCode());
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}

		return result;
	}
	
	private static JSONObject serializeToJson(HttpEntity entity) {
		JSONObject result = null;
		try {
			result = new JSONObject(EntityUtils.toString(entity));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
