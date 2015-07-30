package com.infonomi.sampleapp;

import com.infonomi.indoorpin.sdk.IPFloorPlanView;
import com.infonomi.indoorpin.sdk.IndoorPinSDK;
import com.infonomi.indoorpin.sdk.delegate.IPCallback;
import com.infonomi.indoorpin.sdk.delegate.IndoorPinDelegate;
import com.infonomi.indoorpin.sdk.model.IndoorPinBeacon;
import com.infonomi.indoorpin.sdk.model.IndoorPinUser;

import android.app.Activity; 
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View; 

public class MainActivity extends Activity implements IndoorPinDelegate {
	private IndoorPinSDK indoorPinSDK;
	private IndoorPinUser indoorPinUser;
	private IPFloorPlanView iPNavigationView;
	private Activity a;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		a = this;
		
		indoorPinUser = new IndoorPinUser(
				null, //Fill this if you want to track the customer with your own database customer id. If this is the case, you should set userDB tof your application to YES in CMS
				"Taylor", 
				"Swift", 
				"http://topnews.in/light/files/taylor-swift_6.jpg?1424841363", 
				"taylorswift@gmail.com", 
				IndoorPinUser.IPGENDER_FEMALE, 
				"1980-01-30" // "yyyy-mm-dd"
		); 
		
		indoorPinSDK = new IndoorPinSDK(this, this);
		//PUT_YOUR_API_KEY_HERE  You can see your Api Key in CMS Applications page
		indoorPinSDK.init(indoorPinUser, "36e5ecb5-2ffe-4256-b435-41f838a3e23b", new IPCallback() {
			
			@Override
			public void successful() {
				// TODO Auto-generated method stub
				iPNavigationView = new IPFloorPlanView(a, null);
				setContentView(iPNavigationView.getView());
				//|| rootView.addView(indoorNavigationView) || layout.addView(indoorNavigationView)
				
			}
		});
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
		IndoorPinSDK.bind = true; //if the application is running in the foreground, popups can be displayed.
	}

	@Override
	protected void onStop() {
		super.onStop();
		IndoorPinSDK.bind = false; //if the application is running in the background, notification can be displayed.
	}

	@Override
	public void didChangeBeacon(IndoorPinBeacon ipBeacon) {
		// TODO Auto-generated method stub
	}
}