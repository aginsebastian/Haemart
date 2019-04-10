package com.example.haemart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        json_string = getIntent().getExtras().getString("json_data");
    }
}
