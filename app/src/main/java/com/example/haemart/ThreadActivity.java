package com.example.haemart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ThreadActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ThreadModel> threadlist;
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        json_string = getIntent().getExtras().getString("json_data");
        recyclerView = findViewById(R.id.rw);

        threadlist = new ArrayList<>();

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
                threadlist.add(new ThreadModel(R.drawable.evdp,name,venue,date));
                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
/*
        threadlist.add(new ThreadModel(R.drawable.evdp,"1xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"2xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"3xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"4xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"5xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"6xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"7xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"8xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"9xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"xxxxxx","xxxxx","xxxxx"));
        threadlist.add(new ThreadModel(R.drawable.evdp,"xxxxxx","xxxxx","xxxxx"));
*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rwLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rwLayoutManager);

        ThreadAdapter adapter = new ThreadAdapter(this,threadlist);

        recyclerView.setAdapter(adapter);
    }
}
