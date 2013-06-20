package com.codepath.apps.multiservicerestclient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.multiservicerestclient.FlickrClient;
import com.codepath.apps.multiservicerestclient.R;

public class FlickrLoginFragment extends BaseServiceLoginFragment<FlickrClient> {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_flickr_login, container);
	}
	
	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		setServiceName("Flickr");
		setButtonResId(R.id.btnFlickrLogin);
	}
}
