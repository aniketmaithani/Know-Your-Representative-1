package com.kk.knowyourrepresentative;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnKYR, btnCMP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKYR = (Button) findViewById(R.id.btnKYR);
        btnCMP = (Button) findViewById(R.id.btnCMP);

        btnKYR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KYR.class);
                startActivity(intent);
            }
        });

        btnCMP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CMPActivity.class);
                startActivity(intent);
            }
        });

    }
}
