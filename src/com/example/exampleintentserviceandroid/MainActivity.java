package com.example.exampleintentserviceandroid;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private ResponseReceiver responseReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
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
	public void onStart() {
		// Intent filter for the Receiver
		IntentFilter filter = new IntentFilter(Constants.BROADCAST_ACTION);
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		responseReceiver = new ResponseReceiver();
		// Register my Receiver into LocalBroadcastManager
		LocalBroadcastManager.getInstance(this).registerReceiver(responseReceiver, filter);
		// Start the service
		Intent intent = new Intent(this, MyIntentService.class);
		this.startService(intent);
		super.onStart();
	}
	
	@Override
    public void onStop() {
		LocalBroadcastManager.getInstance(this).unregisterReceiver(responseReceiver);
		super.onStop();
	}
	
	@Override
    public void onDestroy() {
        super.onDestroy();
    }
	
	// Broadcast receiver for receiving status updates from the IntentService
	private class ResponseReceiver extends BroadcastReceiver
	{
	    // Prevents instantiation
	    private ResponseReceiver() {
	    }
	    // Called when the BroadcastReceiver gets an Intent it's registered to receive
	    @Override
	    public void onReceive(Context context, Intent intent) {
	    	
	    	int responseStatus = intent.getIntExtra(Constants.EXTENDED_DATA_STATUS,0);
	    	String responseString = "DEFAULT";
	    	
			switch (responseStatus) {
			case Constants.STATE_ACTION_STARTED:
				responseString = "STARTED";
				break;
			case Constants.STATE_ACTION_COMPLETE:
				responseString = "COMPLETE";
				break;

			}
			Toast.makeText(context, "MyService with estado: " + responseString, Toast.LENGTH_LONG).show();
	    }
	}
}
