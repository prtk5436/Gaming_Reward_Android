package com.example.gamingrewardandroid.Dashboard;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.PointsData;
import com.example.gamingrewardandroid.R;

public class MyGameListAdaptor extends RecyclerView.Adapter<MyGameListAdaptor.ViewHolder> {
    public String[]  gamename;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.gamenm.setText(gamename[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), PointsData.class);
                view.getContext().startActivity(intent);
            }
        });

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
