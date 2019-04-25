package com.example.haemart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;



public class LoginActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;
    TextView t1;
    String json_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        t1 = (TextView)findViewById(R.id.signupbtn);

        json_string = getIntent().getExtras().getString("json_data");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ed1.getText().toString().equals("Admin") && ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    intent.putExtra("json_data", json_string);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                intent.putExtra("json_data", json_string);
                startActivity(intent);
            }
        });
    }

}
