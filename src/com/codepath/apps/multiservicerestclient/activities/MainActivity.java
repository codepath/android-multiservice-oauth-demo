package com.codepath.apps.multiservicerestclient.activities;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.codepath.apps.multiservicerestclient.FlickrClient;
import com.codepath.apps.multiservicerestclient.FoursquareClient;
import com.codepath.apps.multiservicerestclient.R;
import com.codepath.apps.multiservicerestclient.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class MainActivity extends Activity {
	TextView tvFlickr, tvTwitter, tvFoursquare;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		displayFlickrStatus();
		displayTwitterStatus();
		displayFoursquareStatus();
	}
	
	private void displayTwitterStatus() {
		TwitterClient clientTwitter = (TwitterClient) TwitterClient.getInstance(TwitterClient.class, this);
		tvTwitter = (TextView) findViewById(R.id.tvTwitter);
		if (clientTwitter.isAuthenticated()) {
			clientTwitter.getMyInfo(new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(JSONObject j) {
					tvTwitter.setText("Connected to Twitter!");
				}
			});	
		} else {
			tvTwitter.setText("Unauthorized on Twitter");
		}
	}

	private void displayFlickrStatus() {
		FlickrClient  clientFlickr = (FlickrClient) FlickrClient.getInstance(FlickrClient.class, this);
		tvFlickr = (TextView) findViewById(R.id.tvFlickr);
		if (clientFlickr.isAuthenticated()) {
			clientFlickr.getInterestingnessList(new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(JSONObject j) {
					tvFlickr.setText("Connected to Flickr!");
				}
			});
		} else {
			tvFlickr.setText("Unauthorized on Flickr");
		}
	}


	private void displayFoursquareStatus() {
		FoursquareClient clientFoursquare = (FoursquareClient) FoursquareClient.getInstance(FoursquareClient.class, this);
	    tvFoursquare = (TextView) findViewById(R.id.tvFoursquare);
		if (clientFoursquare.isAuthenticated()) {
			clientFoursquare.getSelfUserInfo(new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(JSONObject j) {
					tvFoursquare.setText("Connected to Foursquare!");
				}
			});	
		} else {
			tvFoursquare.setText("Unauthorized on Foursquare");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
