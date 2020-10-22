package com.example.gamingrewardandroid.PointsLog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.Dashboard.DashboardActivity;
import com.example.gamingrewardandroid.Dashboard.MyGameListAdaptor;
import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointsLogActivity extends AppCompatActivity {
    public String[] gamenm;
    TextView textView;
    public String[] point;
    List<UserLog> log;
    RecyclerView recyclerView;
    String [] date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_log);
        recyclerView=findViewById(R.id.recycler_loglist);
        textView=findViewById(R.id.myName);
        textView.setText(FeatureContraoller.getInstance().userDetails.get(0).getName().toString());
       getLog();

        LogAdapter adapter=new LogAdapter(gamenm,point,PointsLogActivity.this,date);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    private void getLog() {
        date=getIntent().getStringArrayExtra("dt");
        gamenm=getIntent().getStringArrayExtra("gamee");
        point=getIntent().getStringArrayExtra("pts");
    }
}