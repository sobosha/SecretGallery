package com.example.gallerysecret.Setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gallerysecret.Core.IView;
import com.example.gallerysecret.MainActivity;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Presenter {


    private static Presenter _global;
    RequestQueue QUEUE;
    String URL;
    String SERVER_KEY = "Bearer "+mLocalData.getToken(MainActivity.getGlobal());

    public Presenter() {
        _global = this;
    }

    public static Presenter get_global() {
        if (_global != null)
            return _global;
        else
            return new Presenter();
    }

    public void OnCreate(Context context, String url, String token) {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            HttpStack stack = null;
            try {
                stack = new HurlStack(null, new TLSSocketFactory());
            } catch (KeyManagementException e) {
                e.printStackTrace();
                stack = new HurlStack();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                stack = new HurlStack();
            }
            QUEUE = Volley.newRequestQueue(context, stack);
        } else {
            QUEUE = Volley.newRequestQueue(context);
        }
        URL = url;
        SERVER_KEY = token;
    }


    public <T, U> void PostAction(final IView RelMaster, String controller, String action, String id, U requestModel, final Class<T> responseType) {
        String strJson;

        Gson gson = new Gson();
        try {
            strJson = gson.toJson(requestModel);
        } catch (Exception e) {
            e.printStackTrace();
            RelMaster.OnError("خطا در تشخیص نوع ورودی", 505);
            return;
        }

        if (!id.isEmpty())
            action = action + "/" + id;

        final String actionStr = action;
        JsonRequest jsObjRequest = new JsonRequest<String>(Request.Method.POST, URL + controller + "/" + action, strJson, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson1 = new Gson();

                try {
                    T responseModel = gson1.fromJson(response, responseType);
                    RelMaster.OnSucceed(responseModel);


                } catch (Exception e) {
                    e.printStackTrace();
                    RelMaster.OnError("خطا در تشخیص داده دریافتی", 506);

                }


            }

        }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                try {

                    RelMaster.OnError("خطا در برقراری اتصال ، اینترنت خود را بررسی کنید", error.networkResponse.statusCode);
                } catch (Exception e) {
                    e.printStackTrace();
                    RelMaster.OnError("خطا در برقراری اتصال ، اینترنت خود را بررسی کنید", 0);

                }
            }


        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer "+mLocalData.getToken(MainActivity.getGlobal()));
                headers.put("Content-Type", "application/json");
                headers.put("Version", Setting.getVersionName());
                headers.put("Toolsid", "1");
                return headers;
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String jsonString = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    jsonString = new String(response.data, StandardCharsets.UTF_8);
                } else
                    jsonString = new String(response.data);
                return Response.success(jsonString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        jsObjRequest.setTag("cancle");
        QUEUE.add(jsObjRequest);

        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1f));
    }





    public <T> void GetAction(final IView RelMaster, final String controller, String action, String id, final Class<T> responseType) {

        if (!id.isEmpty())
            action = action + "/" + id;

        final String actionStr = action;
        StringRequest jsObjRequest = new StringRequest(Request.Method.GET, URL + controller + "/" + action, new Response.Listener<String>() {

            Gson gson = new Gson();
            @Override
            public void onResponse(String response) {

                try {

                    T responseModel = gson.fromJson(response ,responseType);
                    RelMaster.OnSucceed(responseModel);
                } catch (Exception e) {
                    e.printStackTrace();
                    RelMaster.OnError("خطا در تشخیص داده دریافتی", 506);

                }
            }
        }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                try {

                    RelMaster.OnError("خطا در برقراری اتصال ، اینترنت خود را بررسی کنید", error.networkResponse.statusCode);
                } catch (Exception e) {
                    e.printStackTrace();
                    RelMaster.OnError("خطا در برقراری اتصال ، اینترنت خود را بررسی کنید", 0);

                }
            }


        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer "+mLocalData.getToken(MainActivity.getGlobal()));
                headers.put("Content-Type", "application/json");
                headers.put("Version", Setting.getVersionName());
                headers.put("Toolsid", "1");
                return headers;
            }
        };

        jsObjRequest.setTag("cancle");
        QUEUE.add(jsObjRequest);
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(15000, 0, 1f));
    }

    public String getSERVER_KEY() {
        return SERVER_KEY;
    }

    public void setSERVER_KEY(String SERVER_KEY) {
        this.SERVER_KEY = SERVER_KEY;
    }


    public  void cancelReq(){
       if(QUEUE!=null)
           QUEUE.cancelAll("cancle");
    }



}
