package com.kk.knowyourrepresentative;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
 * Created by Karan on 27/4/16.
 */
public class CMPActivity extends Activity {

    EditText edtName, edtMPName, edtPhone, edtLat, edtLong, edtDesc;
    Button submit;

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

        setContentView(R.layout.activity_cmp);

        JSONObject jsonObject = new JSONObject();

        final RequestQueue queue = Volley.newRequestQueue(this);  // this = context

        edtName = (EditText) findViewById(R.id.edtName);
        edtMPName = (EditText) findViewById(R.id.edtMP);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtLat = (EditText) findViewById(R.id.edtLat);
        edtLong = (EditText) findViewById(R.id.edtLong);
        edtDesc = (EditText) findViewById(R.id.edtDesc);
        submit = (Button) findViewById(R.id.btnSubmit);



        try {

            jsonObject.put(KEY_USERNAME, "kk1");
            jsonObject.put(KEY_PHONE_NO, "8860914345");
            jsonObject.put(KEY_DESCRIPTION, "heloooo");
            jsonObject.put(KEY_GEOLOCATION, "14E");
            jsonObject.put(KEY_MP_NAME, "yo");
            jsonObject.put(KEY_PHOTO, null);

//             String name = edtName.getText().toString();
//             String mp_name = edtMPName.getText().toString();
//             int phone = Integer.parseInt(edtPhone.getText().toString());
//             String desc = edtDesc.getText().toString();
//             String latitude = edtLat.getText().toString();
//             String longitute = edtLong.getText().toString();
//
//            jsonObject.put(KEY_USERNAME, name);
//            jsonObject.put(KEY_PHONE_NO, phone);
//            jsonObject.put(KEY_DESCRIPTION, desc);
//            jsonObject.put(KEY_GEOLOCATION, "14E");
//            jsonObject.put(KEY_MP_NAME, mp_name);
//            jsonObject.put(KEY_PHOTO, null);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, complaintsURL, jsonObject,
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add(request);
            }
        });

    }
}