package com.droidfire.ui;

import com.droidfire.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //Check to see if user token and url are stored
        
        SharedPreferences credentials = this.getSharedPreferences("credentials", MODE_PRIVATE);
        String token = credentials.getString("token", "");
        if (token != "") {  //If we have the information, send on to the room list
        	
        } else { 			//If we dont, show the login information
        	
        }
        
        setContentView(R.layout.main);
    }
}