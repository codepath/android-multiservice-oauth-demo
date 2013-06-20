package com.codepath.apps.multiservicerestclient;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.Foursquare2Api;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class FoursquareClient extends OAuthBaseClient {
    public static final Class<? extends Api> REST_API_CLASS = Foursquare2Api.class; 
    public static final String REST_URL = "https://api.foursquare.com/v2";
    public static final String REST_CONSUMER_KEY = "PBJPBQZGZKCDXCSWD2OGGIWKOKR3KXKJORSZMBKA1GNLKJUD";    
    public static final String REST_CONSUMER_SECRET = "Z0JNWXGL440F2EYVW4EZWRITY3QJNR1LCFALMI3IN2T5ZVOO";
    public static final String REST_CALLBACK_URL = "oauth://cpmultifoursquare.com"; 
    
    public FoursquareClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
    }
    
    // response.user.firstName
    public void getSelfUserInfo(AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("users/self");
        RequestParams params = new RequestParams();
        params.put("foo", "bar");
        params.put("bar", "baz");
        client.get(apiUrl, params, handler);
    }
}