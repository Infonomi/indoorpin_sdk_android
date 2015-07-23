package com.infonomi.sampleapp;

import com.infonomi.indoorpin.sdk.IPNavigationView; 
import com.infonomi.indoorpin.sdk.IndoorPinSDK;
import com.infonomi.indoorpin.sdk.model.IndoorPinUser;

import android.app.Activity; 
import android.os.Bundle; 
import android.view.Menu;
import android.view.MenuItem; 

public class MainActivity extends Activity {
	private IndoorPinSDK indoorPinSDK;
	private IndoorPinUser indoorPinUser;
	private IPNavigationView iPNavigationView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		
		iPNavigationView = new IPNavigationView(getApplicationContext());
		setContentView(iPNavigationView.getView());
		
		indoorPinUser = new IndoorPinUser(null, "Ýbrahim", "Gündüz", 
				"http://www.cincinnatihornets.com/wp-content/uploads/2014/04/facebook-default-no-profile-pic.jpg", 
				"igunduz91@gmail.com", "M", "1991-02-19");
		
		indoorPinSDK = new IndoorPinSDK(this, iPNavigationView);
		indoorPinSDK.init(indoorPinUser, "36e5ecb5-2ffe-4256-b435-41f838a3e23b");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		IndoorPinSDK.bind = true; 
	}

	@Override
	protected void onStop() {
		super.onStop();
		IndoorPinSDK.bind = false; 
	} 
}