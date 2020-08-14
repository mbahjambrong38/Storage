package com.baru.storage.request;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.baru.storage.MainActivity;
import com.baru.storage.preferences.Preferences;
import com.baru.storage.user.LogedUser;

import org.json.JSONException;
import org.json.JSONObject;

public class Request {
    Context ctx;
    public Activity activity;

    public Request(Context ctx, Activity activity){
        this.ctx = ctx;
        this.activity = activity;
    }


    public void getJson( String READ, String URL_READ){
        RequestFuture<JSONObject> future = RequestFuture.newFuture();
        RequestQueue queue = Volley.newRequestQueue(ctx);
        JsonArrayRequest request = new JsonArrayRequest(URL_READ,
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject obj = response.getJSONObject(i);

                            switch (READ){
                                case "Stock View":
                                    getViewStock(obj);
                                    break;

                                case "User":
                                    getUser(obj);
                                    break;

                                default:
                                    Log.d("ERROR ADD VEC", "DEFAULT ERROR SWITCH");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (LogedUser.userID == 0) {
                    Toast.makeText(ctx, "INVALID USERNAME OR PASSWORD", Toast.LENGTH_SHORT).show();
                }
            }
        });

        queue.add(request);
    }

    public void getViewStock(JSONObject obj) throws JSONException {

    }

    public void getUser(JSONObject obj) throws JSONException {
        LogedUser.userID = obj.getInt("userID");
        LogedUser.userName = obj.getString("userName");
        LogedUser.userPassword = obj.getString("userPassword");
        LogedUser.Role = obj.getString("role");
        Log.d("User : ", "ID " + LogedUser.userID + " Name " + LogedUser.userName);

        if (LogedUser.userID != 0) {
            Preferences.setContext(ctx);
            Preferences.actionLogin(LogedUser.userName, LogedUser.userPassword, LogedUser.userID);
            Intent intent = new Intent(ctx, MainActivity.class);
            ctx.startActivity(intent);
            activity.finish();
        }

    }


}
