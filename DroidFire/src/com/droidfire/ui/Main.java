package com.droidfire.ui;

import java.net.URI;

import com.droidfire.R;
import com.droidfire.campfire.Site;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity implements OnClickListener {
    
	private EditText mSiteName;
	private EditText mUsername;
	private EditText mPassword;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        
        //Check to see if user token and url are stored        
        SharedPreferences credentials = this.getSharedPreferences("credentials", MODE_PRIVATE);
        String token = credentials.getString("token", "");
        if (token.equals("")) {  //If we dont, show the login information
        	setContentView(R.layout.main);
        	Button loginButton = (Button)findViewById(R.id.loginButton);
        	loginButton.setOnClickListener(this);
        } else { 			//If we have the information, send on to the room list
        	showRoomsList(token, URI.create("http://" + mSiteName.getText() + ".campfirenow.com"));
        }        
    }

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.loginButton:
			URI siteLocation = URI.create("http://" + mSiteName.getText() + ".campfirenow.com");
			Site site = new Site(siteLocation);
			String token = site.login(mUsername.getText().toString(), mPassword.getText().toString());
			if (!token.equals("")) { 	//Successful login
				showRoomsList(token, siteLocation);
			} else {					//Unsuccessful login
				
			}
			break;
		default:
			break;
		}		
	}
	
	private void showRoomsList(String token, URI site) {
		Intent loadRooms = new Intent(this, Rooms.class);
    	loadRooms.putExtra("token", token);
    	loadRooms.putExtra("site", site.toString());
    	startActivity(loadRooms);
    	this.finish();
	}
}