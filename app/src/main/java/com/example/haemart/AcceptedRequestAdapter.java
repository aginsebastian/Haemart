package com.example.haemart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AcceptedRequestAdapter extends RecyclerView.Adapter<AcceptedRequestAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<AcceptedRequestModel> mList;

    AcceptedRequestAdapter(Context context, ArrayList<AcceptedRequestModel> list){
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.acceptedrequestcard,viewGroup,false);
        ViewHolder viewHolder    = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        AcceptedRequestModel carditem = mList.get(i);

        ImageView image = viewHolder.rcimage;
        TextView name,venue,date;

        name = viewHolder.rcname;
        venue = viewHolder.rcvenue;
        date = viewHolder.rcdate;

        image.setImageResource(carditem.getImage());
        name.setText(carditem.getName());
        venue.setText(carditem.getVenue());
        date.setText(carditem.getDate());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView rcimage;
        TextView rcname,rcvenue,rcdate;

        public ViewHolder(View itemView) {

            super(itemView);

            rcimage = itemView.findViewById(R.id.arimage);
            rcname = itemView.findViewById(R.id.arname);
            rcvenue = itemView.findViewById(R.id.arvenue);
            rcdate = itemView.findViewById(R.id.ardate);

        }
    }

}
