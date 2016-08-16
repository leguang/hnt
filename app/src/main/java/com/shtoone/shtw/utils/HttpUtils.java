package com.shtoone.shtw.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shtoone.shtw.BaseApplication;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by leguang on 2015/5/29.
 */
public class HttpUtils {
    public static RequestQueue queue = Volley.newRequestQueue(BaseApplication.application);


    private HttpUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * get请求方式，通过StringRequest进行请求
     *
     * @param url
     * @param listener
     */
    public static void getRequest(String url, final HttpListener listener) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailed(error);
            }
        });
        queue.add(request);
    }

    /**
     * post请求方式，通过key-value方式来提交，使用StringRequest请求
     *
     * @param url
     * @param params
     * @param listener
     */
    public static void postRequest(String url, final Map<String, String> params, final HttpListener listener) {

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailed(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        queue.add(request);
    }

    /**
     * post请求方式，通过json方式来提交，使用JsonObjectRequest请求
     *
     * @param url
     * @param params
     * @param listener
     */
    public static void postJsonRequest(String url, Map<String, String> params, final HttpListener listener) {
        JSONObject jsonObject = new JSONObject(params);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.onSuccess(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onFailed(error);
            }
        });
        queue.add(request);
    }

    public interface HttpListener {
        void onSuccess(String response);

        void onFailed(VolleyError error);
    }
}
