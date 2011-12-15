package com.droidfire.ui;

import android.app.Activity;
import android.os.Bundle;

public class Rooms extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String token = savedInstanceState.getString("token");
	}
}
