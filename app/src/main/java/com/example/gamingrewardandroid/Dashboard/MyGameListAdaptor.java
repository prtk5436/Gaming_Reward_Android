package com.example.gamingrewardandroid.Dashboard;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.gamingrewardandroid.PointsForm.PointsDataForm;
import com.example.gamingrewardandroid.R;

public class MyGameListAdaptor extends RecyclerView.Adapter<MyGameListAdaptor.ViewHolder> {
    public String[]  gamename;
    public String[] id;
    public String[] gameimg;

    Context context;
    MyGameListAdaptor( String[] names, String[] gameimg,Context context, String[] id){
        this.gamename=names;
        this.id=id;
        this.gameimg=gameimg;
        this.context=context;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.gamenm.setText(gamename[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), PointsDataForm.class);
                intent.putExtra("gamename",gamename[position]);
                intent.putExtra("gameid",id[position]);
                intent.putExtra("url",gameimg[position]);
                view.getContext().startActivity(intent);

            }
        });
        Glide.with(context)
                .load(gameimg[position])
                .apply(RequestOptions.circleCropTransform())
                .thumbnail(0.5f)
                .placeholder(R.drawable.images)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.gameimage);

    }

    @Override
    public int getItemCount() {
        return gamename.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView gamenm;
        ImageView gameimage;
        RelativeLayout gamelayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gamelayout=itemView.findViewById(R.id.gamelayout);
            gamenm=itemView.findViewById(R.id.txt_gamename);
            gameimage=itemView.findViewById(R.id.imageView_game);
        }
    }
}
