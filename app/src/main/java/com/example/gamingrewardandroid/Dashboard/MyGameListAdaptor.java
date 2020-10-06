package com.example.gamingrewardandroid.Dashboard;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.R;

public class MyGameListAdaptor extends RecyclerView.Adapter<MyGameListAdaptor.ViewHolder> {
    public String[] gamename;
    MyGameListAdaptor(String [] names){
        this.gamename=names;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View gamelists=layoutInflater.inflate(R.layout.gamelistlayout,parent,false);
        ViewHolder viewHolder=new ViewHolder(gamelists);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gamenm.setText(gamename[position]);


    }

    @Override
    public int getItemCount() {
        return gamename.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView gamenm;
        RelativeLayout gamelayout;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            gamelayout=itemView.findViewById(R.id.gamelayout);
            gamenm=itemView.findViewById(R.id.txt_gamename);
        }
    }
}
