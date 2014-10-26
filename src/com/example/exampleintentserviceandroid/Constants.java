package com.example.exampleintentserviceandroid;

public final class Constants {
	
	//Tag log
	public static final String TAG = "com.example.exampleintentserviceandroid";
	
	// Set to true to turn on verbose logging
    public static final boolean LOGV = false;
    
    // Set to true to turn on debug logging
    public static final boolean LOGD = true;
    
    // Defines a custom Intent action
    public static final String BROADCAST_ACTION = "com.example.exampleintentserviceandroid.BROADCAST";

    // Defines the key for the status "extra" in an Intent
    public static final String EXTENDED_DATA_STATUS = "com.example.exampleintentserviceandroid.STATUS";

    // Defines the key for the log "extra" in an Intent
    public static final String EXTENDED_STATUS_LOG = "com.example.exampleintentserviceandroid.LOG";

    // Status values to broadcast to the Activity //
    
    // The service is starting
    public static final int STATE_ACTION_STARTED = 0;

    // The service is done
    public static final int STATE_ACTION_COMPLETE = 1;

    // The service is doing logging
    public static final int STATE_LOG = -1;

}
