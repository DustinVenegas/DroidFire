package com.droidfire.ui;

import com.droidfire.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                
        //Check to see if user token and url are stored        
        SharedPreferences credentials = this.getSharedPreferences("credentials", MODE_PRIVATE);
        String token = credentials.getString("token", "");
        if (token == "") {  //If we dont, show the login information
        	setContentView(R.layout.main);
        	Button loginButton = (Button)findViewById(R.id.loginButton);
        	loginButton.setOnClickListener(this);
        } else { 			//If we have the information, send on to the room list
        	Intent loadRooms = new Intent(this, Rooms.class);
        	loadRooms.putExtra("token", token);
        	startActivity(loadRooms);
        	this.finish();
        }        
    }

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.loginButton:
			
			break;
		default:
			break;
		}		
	}
}