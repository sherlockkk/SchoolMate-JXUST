package com.alpha.schoolmate;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jason Sun on 2015/11/6.
 * <p/>
 * 邮箱：1129574214@qq.com
 */
public class MyApplication extends Application {
    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpRequestQueue(){
        return requestQueue;
    }
}
