package com.example.gamingrewardandroid.PointsLog;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.gamingrewardandroid.Dashboard.MyGameListAdaptor;
import com.example.gamingrewardandroid.PointsForm.PointsDataForm;
import com.example.gamingrewardandroid.R;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.MyLog> {
    public String[]  gamename;
    public String[] points;
    public String[] date;
    Context context;
    public String[] gameimg;
    LogAdapter(String[] gamename, String[] points, Context context,String[] date,String[] gameimg){
        this.gamename=gamename;
        this.points=points;
        this.gameimg=gameimg;
        this.context=context;
        this.date=date;

    }
    @NonNull
    @Override
    public MyLog onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View gamelog=layoutInflater.inflate(R.layout.pointsloglayout,parent,false);
         LogAdapter.MyLog myLog=new LogAdapter.MyLog(gamelog);
        return myLog;

    }

    @Override
    public void onBindViewHolder(@NonNull MyLog holder, final int position)
    {
        holder.gamename.setText(gamename[position]);
        holder.dates.setText(""+date[position]);
        holder.points.setText(points[position]/*+"\nPoints"*/);
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent intent=new Intent(getAppliactionContext(), PointsLogActivity.class);
        intent.putExtra("url",gameimg[position]);
                view.getContext().startActivity(intent);

 */
      Glide.with(context)
                .load(gameimg[position])
                .apply(RequestOptions.circleCropTransform())
                .thumbnail(0.5f)
                .placeholder(R.drawable.images)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.gameimg);
  }



    @Override
    public int getItemCount() {
        return gamename.length;
    }

    public class MyLog extends RecyclerView.ViewHolder {
        TextView gamename,points,dates;
        ImageView gameimg;
        public MyLog(@NonNull View itemView) {
            super(itemView);
            gamename=itemView.findViewById(R.id.txt_gamename);
            points=itemView.findViewById(R.id.txt_points_earned);
            dates=itemView.findViewById(R.id.txt_dt);
            gameimg=itemView.findViewById(R.id.imageView_game);
        }
    }
}
