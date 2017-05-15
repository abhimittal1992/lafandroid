package com.laf.lostandfound.util;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by durlabhsharma on 15/5/17.
 */

public class VolleyRequestQueue {
    private static VolleyRequestQueue instance;
    private static Context context;
    private RequestQueue requestQueue;

    public VolleyRequestQueue(Context context) {
        this.context = context;
        this.requestQueue = getRequestQueue();
    }
    public static synchronized VolleyRequestQueue getInstance(Context context) {
        if(instance == null) {
            instance = new VolleyRequestQueue(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
