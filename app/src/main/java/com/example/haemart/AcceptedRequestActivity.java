package com.example.haemart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AcceptedRequestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<AcceptedRequestModel> acceptedrequestlist;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepted_request);

        json_string = getIntent().getExtras().getString("json_data");
        recyclerView = findViewById(R.id.accepted_request_re);

        acceptedrequestlist = new ArrayList<>();

        try{
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("thread");
            int count = 0;
            String name,venue,date,img;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                img = JO.getString("image");
                name = JO.getString("name");
                venue = JO.getString("venue");
                date = JO.getString("date");
                acceptedrequestlist.add(new AcceptedRequestModel(R.drawable.evdp,name,venue,date));
                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rwLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rwLayoutManager);

        AcceptedRequestAdapter adapter = new AcceptedRequestAdapter(this,acceptedrequestlist);

        recyclerView.setAdapter(adapter);
    }
}
