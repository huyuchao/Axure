package com.axure.core;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import okhttp3.OkHttpClient;

/**
 * <br/>
 * Created by hyc on 2017/11/17.
 */
public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
//        AndroidNetworking.setParserFactory(new JacksonParserFactory());
    }
}
