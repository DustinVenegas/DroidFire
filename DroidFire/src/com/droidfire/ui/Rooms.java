package com.droidfire.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

public class Rooms extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String token = savedInstanceState.getString("token");
		Uri siteUri = Uri.parse(savedInstanceState.getString("site"));
		
		
	}
}
