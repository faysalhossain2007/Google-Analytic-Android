package com.faysal.googletracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class TrackerActivity extends Activity {

	GoogleAnalyticsTracker tracker;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Start your statistics tracking
		tracker = GoogleAnalyticsTracker.getInstance();
	
		// tracker.start("UA-40662362-1",30,this);
		tracker.start("UA-40662362-2", 30, this);
		
		
		
		
		tracker.setDebug(true);

		setContentView(R.layout.main);
		tracker.trackPageView("/Google-Tracker");

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		tracker.stop();
	}

	public void onClickOptionAButton(View v) {
		// High button clicked.
		Toast.makeText(TrackerActivity.this, "Option A",
				Toast.LENGTH_SHORT).show();
		tracker.trackEvent("Clicks", "Button", "High Road", 0);
	}

	public void onClickOptionBButton(View v) {
		// High button clicked.
		Toast.makeText(TrackerActivity.this, "Option B",
				Toast.LENGTH_SHORT).show();
		tracker.trackEvent("Clicks", "Button", "Low Road", 0);
	}
}