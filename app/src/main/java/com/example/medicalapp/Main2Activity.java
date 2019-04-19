package com.example.medicalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txtvw = (TextView) findViewById(R.id.finalText);
        txtvw.setText(getIntent().getExtras().getString("tct1"));

    }
}
