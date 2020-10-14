package com.example.gamingrewardandroid.PointsForm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.gamingrewardandroid.Dashboard.DashboardActivity;
import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.R;

public class PointsEarnedActivity extends AppCompatActivity {
   TextView name,points;
   String nm,pts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_earned);
        name =findViewById(R.id.usernm);
        points=findViewById(R.id.pts);
        nm= FeatureContraoller.getInstance().userDetails.get(0).getName();
        Intent intent=getIntent();
        pts=FeatureContraoller.getInstance().getPoint().toString();

        name.setText(nm);
        points.setText(pts+" Points");

    }

    public void ondashboard(View view) {

        startActivity(new Intent(PointsEarnedActivity.this, DashboardActivity.class));
    }
}