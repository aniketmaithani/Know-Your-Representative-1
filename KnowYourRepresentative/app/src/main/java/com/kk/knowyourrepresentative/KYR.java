package com.kk.knowyourrepresentative;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Karan on 27/4/16.
 */
public class KYR  extends AppCompatActivity {

    EditText edtCand;
    Button btnsearch;
    String paramURL;

    JSONArray results = null;

    String mp_name, state,  attendance, constituency;

    private static final String TAG_RESULTS = "results";
    private static final String TAG_MP_NAME = "name_of_the_mp";
    private static final String TAG_STATE = "state";
    private static final String TAG_PHOTO_OF_MP = "photo_of_the_mp";
    private static final String TAG_ATTENDANCE = "attendance_percent";
    private static final String TAG_CONSTITUENCY = "constituency";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kyr_main);

        edtCand = (EditText) findViewById(R.id.edtCandidate1);
        btnsearch = (Button) findViewById(R.id.btnSearch);

        final RequestQueue queue = Volley.newRequestQueue(this);  // this = context

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paramURL = edtCand.getText().toString();

                final String membersAttendanceURL = "https://know-your-representative.herokuapp.com/api/" +
                        "membersearch/name/"+paramURL+"/";

                StringRequest stringRequest = new StringRequest(Request.Method.GET, membersAttendanceURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.e("Response",response);

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    results = jsonObject.getJSONArray(TAG_RESULTS);
                                    for (int i = 0; i < results.length(); i++){
                                        JSONObject object = results.getJSONObject(i);
                                        mp_name = object.getString(TAG_MP_NAME);
                                        state = object.getString(TAG_STATE);
                                        attendance = object.getString(TAG_ATTENDANCE);
                                        constituency = object.getString(TAG_CONSTITUENCY);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                if (response != null){

                                    Intent intent = new Intent(KYR.this, KYRActivity.class);

                                    intent.putExtra(TAG_MP_NAME, mp_name);
                                    intent.putExtra(TAG_STATE, state);
                                    intent.putExtra(TAG_CONSTITUENCY, constituency);
                                    intent.putExtra(TAG_ATTENDANCE, attendance);

                                    startActivity(intent);
                                }else {
                                    Toast.makeText(KYR.this, "Chech MP's name",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(KYR.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        });
                queue.add(stringRequest);
            }
        });

    }
}
