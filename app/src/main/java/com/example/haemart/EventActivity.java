package com.example.haemart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<EventModel> eventlist;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        json_string = getIntent().getExtras().getString("json_data");
        recyclerView = findViewById(R.id.eventre);

        eventlist = new ArrayList<>();

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
                eventlist.add(new EventModel(R.drawable.evdp,name,venue,date));
                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rwLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rwLayoutManager);

        EventAdapter adapter = new EventAdapter(this,eventlist);

        recyclerView.setAdapter(adapter);
    }
}
