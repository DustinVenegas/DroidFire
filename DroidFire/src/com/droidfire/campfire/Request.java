package com.droidfire.campfire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
			JSONObject data = serializeToJson(httpResponse.getEntity().getContent());
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
	
	private static JSONObject serializeToJson(InputStream stream) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringBuilder sb = new StringBuilder();
		
		String line = null;
		JSONObject result = null;
		
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			result = new JSONObject(sb.toString());
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
