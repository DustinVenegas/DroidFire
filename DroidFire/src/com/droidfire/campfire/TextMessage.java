package com.droidfire.campfire;

import org.json.JSONException;
import org.json.JSONObject;

public class TextMessage extends Message {

	public TextMessage(String body) {
		mBody = body;
	}
	
	@Override
	public JSONObject toJSONObject() {
		JSONObject json = new JSONObject();
		try {
			JSONObject message = new JSONObject();
			message.put("type", "TextMessage");
			message.put("body", mBody);
			json.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return json;
	}
	
}
