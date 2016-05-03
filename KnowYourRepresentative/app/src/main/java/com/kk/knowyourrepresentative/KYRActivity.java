package com.kk.knowyourrepresentative;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Karan on 27/4/16.
 */
public class KYRActivity extends Activity{

    TextView textCand, textState, textConstituency, textAttendance,
            textCandResult, textStateResult, textConstituencyResult, textAttendanceResult;

    private static final String TAG_MP_NAME = "name_of_the_mp";
    private static final String TAG_STATE = "state";
    private static final String TAG_PHOTO_OF_MP = "photo_of_the_mp";
    private static final String TAG_ATTENDANCE = "attendance_percent";
    private static final String TAG_CONSTITUENCY = "constituency";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_kyr);

        Intent intent = getIntent();

        String mp_name = intent.getStringExtra(TAG_MP_NAME);
        String state = intent.getStringExtra(TAG_STATE);
        String constituency = intent.getStringExtra(TAG_CONSTITUENCY);
        String attendance = intent.getStringExtra(TAG_ATTENDANCE);


        textCand = (TextView) findViewById(R.id.textCand);
        textState = (TextView) findViewById(R.id.textState);
        textConstituency = (TextView) findViewById(R.id.textConstituency);
        textAttendance = (TextView) findViewById(R.id.textAttend);

        textCandResult = (TextView) findViewById(R.id.textCandResult);
        textStateResult = (TextView) findViewById(R.id.textStateResult);
        textConstituencyResult = (TextView) findViewById(R.id.textConstituencyResult);
        textAttendanceResult = (TextView) findViewById(R.id.textAttendanceResult);

        textCandResult.setText(mp_name);
        textStateResult.setText(state);
        textConstituencyResult.setText(constituency);
        textAttendanceResult.setText(attendance);
    }
}
