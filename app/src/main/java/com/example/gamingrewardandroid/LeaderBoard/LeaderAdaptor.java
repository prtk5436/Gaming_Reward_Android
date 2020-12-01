package com.example.gamingrewardandroid.LeaderBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamingrewardandroid.Dashboard.MyGameListAdaptor;
import com.example.gamingrewardandroid.R;

import java.util.List;

public class LeaderAdaptor extends RecyclerView.Adapter<LeaderAdaptor.Leader> {
    List<Top5GamerName> leaders;
    Context context;

    public LeaderAdaptor(List<Top5GamerName> leaders, Context context) {
        this.leaders = leaders;
        this.context = context;
    }

    @NonNull
    @Override
    public LeaderAdaptor.Leader onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View gamelists=layoutInflater.inflate(R.layout.leaderlayout,parent,false);
        LeaderAdaptor.Leader leader=new LeaderAdaptor.Leader(gamelists);
        //MyGameListAdaptor.ViewHolder viewHolder=new MyGameListAdaptor.ViewHolder(gamelists);
        return leader;


    }

    @Override
    public void onBindViewHolder(@NonNull LeaderAdaptor.Leader holder, int position) {
        holder.leadername.setText(leaders.get(position).getGamerName().toString());
        holder.score.setText(leaders.get(position).getPoints().toString()+" Points");
    }

    @Override
    public int getItemCount() {
        return leaders.size();
    }

    public class Leader extends RecyclerView.ViewHolder {
        TextView leadername,score;
        public Leader(@NonNull View itemView) {
            super(itemView);
            leadername=itemView.findViewById(R.id.gamernm);
            score=itemView.findViewById(R.id.pts);
        }
    }
}
