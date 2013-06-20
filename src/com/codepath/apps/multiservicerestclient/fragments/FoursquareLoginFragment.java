package com.codepath.apps.multiservicerestclient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.multiservicerestclient.FoursquareClient;
import com.codepath.apps.multiservicerestclient.R;

public class FoursquareLoginFragment extends BaseServiceLoginFragment<FoursquareClient> {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_foursquare_login, container);
	}
	
	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		setServiceName("Foursquare");
		setButtonResId(R.id.btnFoursquareLogin);
	}
}
