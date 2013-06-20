package com.codepath.apps.multiservicerestclient.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.multiservicerestclient.R;
import com.codepath.apps.multiservicerestclient.TwitterClient;

public class TwitterLoginFragment extends BaseServiceLoginFragment<TwitterClient> {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_twitter_login, container);
	}
	
	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		setServiceName("Twitter");
		setButtonResId(R.id.btnTwitterLogin);
	}
}
