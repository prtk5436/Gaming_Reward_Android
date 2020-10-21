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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_log);
        recyclerView=findViewById(R.id.recycler_loglist);
        textView=findViewById(R.id.myName);
        textView.setText(FeatureContraoller.getInstance().getFullName());
       getLog();

        LogAdapter adapter=new LogAdapter(gamenm,point,PointsLogActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    private void getLog() {

        gamenm=getIntent().getStringArrayExtra("gamee");
        point=getIntent().getStringArrayExtra("pts");
    }
}