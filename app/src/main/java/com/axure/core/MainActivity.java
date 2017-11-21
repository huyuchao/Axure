package com.axure.core;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends Activity {

    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info = findViewById(R.id.tv_info);

        Observable observable = Observable.just("hello","world");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(String o) {
                Log.e("onNex"," o = "+o);
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
        AndroidNetworking.get("https://www.baidu.com/").addQueryParameter("wd", "param").build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                Log.e("onResponse", " response = " + response);
                tv_info.setText(response);
            }

            @Override
            public void onError(ANError anError) {
                Log.e("onResponse", " anError = " + anError);
            }
        });

    }
}
