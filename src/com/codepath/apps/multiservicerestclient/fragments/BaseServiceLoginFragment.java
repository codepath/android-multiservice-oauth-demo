package com.codepath.apps.multiservicerestclient.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.codepath.oauth.OAuthBaseClient;
import com.codepath.oauth.OAuthLoginFragment;

public abstract class BaseServiceLoginFragment<T extends OAuthBaseClient> extends OAuthLoginFragment<T> {
	private int resIdButton;
	private Button btnLogin;
	private String serviceName;
	
	public void setServiceName(String name) {
		serviceName = name;
	}
	
	public void setButtonResId(int resId) {
		resIdButton = resId;
	}
	
	@Override
	public void onActivityCreated(Bundle saved) {
		super.onActivityCreated(saved);
		findButton().setText("Connect to " + serviceName);
		findButton().setOnClickListener(new ServiceButtonOnClickListener());	
		if (getClient().isAuthenticated()) {
			onLoginSuccess();
		}
	}
	
	@Override
	public void onLoginSuccess() {
      if (findButton() != null) { findButton().setText("Disconnect " + serviceName); }
	  Toast.makeText(getActivity(), serviceName + " connected!", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onLoginFailure(Exception e) {
		Log.d("DEBUG", e.toString());
	}
	
	public Button findButton() {
		if (btnLogin == null) { btnLogin = (Button) getActivity().findViewById(resIdButton); };
		return btnLogin;
	}
	
	private class ServiceButtonOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (getClient().isAuthenticated()) {
				getClient().clearAccessToken();
				findButton().setText("Connect to " + serviceName);
			} else {
				getClient().connect();
			}
		}
	}
}
