package com.kk.knowyourrepresentative;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Karan on 29/4/16.
 */
public class MultipartUtility extends Activity{
    private String complaintsURL = "https://know-your-representative.herokuapp.com/api/complaints/";




    public static final String KEY_USERNAME = "name_of_the_complainee";
    public static final String KEY_MP_NAME = "name_of_the_mp_for_problem_redressal";
    public static final String KEY_PHONE_NO = "phone_number_of_the_complainee";
    public static final String KEY_GEOLOCATION = "geolocation";
    public static final String KEY_DESCRIPTION = "description_of_the_problem";
    public static final String KEY_PHOTO = "photo_of_the_area";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JSONObject jsonObject = new JSONObject();

        RequestQueue queue = Volley.newRequestQueue(this);  // this = context

        try {

            jsonObject.put(KEY_USERNAME, "KARAN");
            jsonObject.put(KEY_PHONE_NO, "99999999");
            jsonObject.put(KEY_DESCRIPTION, "cnlndvlkkndvklnlds");
            jsonObject.put(KEY_GEOLOCATION, "14E");
            jsonObject.put(KEY_MP_NAME, "Khurana");
            jsonObject.put(KEY_PHOTO, null);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, complaintsURL, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(request);

    }
}
