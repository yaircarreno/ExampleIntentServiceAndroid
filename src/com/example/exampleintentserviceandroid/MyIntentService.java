package com.example.exampleintentserviceandroid;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
	
	// Defines and instantiates an object for handling status updates.
    private BroadcastNotifier mBroadcaster;

	public MyIntentService() {
		super("MyIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
		mBroadcaster = new BroadcastNotifier(this);
		// Broadcasts an Intent indicating that processing has started.
        mBroadcaster.broadcastIntentWithState(Constants.STATE_ACTION_STARTED);

		for (int i = 0; i < 10000; i++) {
			Log.i(Constants.TAG, "Procesing " + i);
		}
		
		// Reports that the feed retrieval is complete.
        mBroadcaster.broadcastIntentWithState(Constants.STATE_ACTION_COMPLETE);
	}
}
