package com.example.haemart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button thread,events,map,profile,raisedrq,acceptedrq,nearbyhp;
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        json_string = getIntent().getExtras().getString("json_data");
        thread = (Button)findViewById(R.id.thread);
        events = (Button)findViewById(R.id.events);
        profile = (Button)findViewById(R.id.profile);
        map = (Button)findViewById(R.id.map);
        raisedrq = (Button)findViewById(R.id.raisedrq);
        acceptedrq = (Button)findViewById(R.id.acceptedrq);
        nearbyhp= (Button)findViewById(R.id.nearbyhp);

        thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ThreadActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),EventActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });

        raisedrq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),RaisedRequestActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });

        acceptedrq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),AcceptedRequestActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });

        nearbyhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),NearbyActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });


    }

}
