package com.example.gamingrewardandroid.Dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamingrewardandroid.AuthenticationApi;

import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.GamerProfile.GamerProfileActivity;
import com.example.gamingrewardandroid.LoginStudent.LoginActivity;
import com.example.gamingrewardandroid.Model.Post;
import com.example.gamingrewardandroid.Model.Posts1;
import com.example.gamingrewardandroid.PointsLog.PointLogInput;
import com.example.gamingrewardandroid.PointsLog.PointLogOuput;
import com.example.gamingrewardandroid.PointsLog.PointsLogActivity;
import com.example.gamingrewardandroid.PointsLog.UserLog;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.StudentsPoints.InputPoints;
import com.example.gamingrewardandroid.StudentsPoints.OutputPoints;
import com.example.gamingrewardandroid.SuggestGame.SuggestGame;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//pramod khandare10-01-2019
public class DashboardActivity extends AppCompatActivity{
    ImageButton btnoption;

    RecyclerView recyclerView;
    private ListView playerslist;
    private Button btnassign;
    private TextView myName,myPoints ;
    private EditText et_P_number,et_P_name;
    private Context _context;
    private List<Post> posts;
    private List<Posts1> posts1;
    private RatingBar ratingbar;
    private ProgressBar pBar1;
    private List<String> sportsName = new ArrayList<String>();
    private List<String> playerName = new ArrayList<String>();
    private SharedPreferences prf;
    private String points = "0";
    public String[] gamenm;
    public String[] point;
    public  String [] dt;
    List<UserLog> log;

    private Toolbar toolbar;
    private ArrayAdapter playerlistAdapter;
    FeatureContraoller featureContraoller;
    ArrayList<GameList> gamelist=new ArrayList<>();
    public  String[] gamename;
    public  String[] id;

    public String[] gameimg;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        //displaySpectatorPoints();
        Log.i("In OnCreate", "In OnCreate");
        getlist();

        init();


        // pref = getSharedPreferences("user_details",MODE_PRIVATE);
        prf = getSharedPreferences("user_details",MODE_PRIVATE);
        String category = prf.getString("category","");



        getStudentPoints();




        myName.setText(FeatureContraoller.getInstance().getUserDetails().get(0).getName());

        MyGameListAdaptor gameListAdaptor=new MyGameListAdaptor(gamename,gameimg,DashboardActivity.this,id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(gameListAdaptor);
    }

    private void getlist() {
        gamelist=FeatureContraoller.getInstance().getGamelist();
        int count=gamelist.size();

        gamename=new String[count];
        gameimg=new String[count];
        id=new String[count];
        for (int i=0;i<count ;i++){
            gamename[i]=gamelist.get(i).getGameName().toString();
            gameimg[i]=gamelist.get(i).getGameimage().toString();
            id[i]=gamelist.get(i).getGameId().toString();

        }
    }

    private void init() {
        btnoption=findViewById(R.id.btn_option);
        myName = (TextView)findViewById(R.id.myName);
        myPoints = (TextView)findViewById(R.id.myPoints);
        //sportlist = (Spinner)findViewById(R.id.sportlist);
        //btnassign = (Button)findViewById(R.id.btnassign);
        recyclerView=findViewById(R.id.recycler_gamelist);
        et_P_number = (EditText)findViewById(R.id.et_P_number);
        et_P_name = (EditText)findViewById(R.id.et_P_name);
        //playerslist = (ListView) findViewById(R.id.player_list);
        //ratingbar = (RatingBar)findViewById(R.id.ratingBar);
        pBar1 = (ProgressBar) findViewById(R.id.pBar1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.a,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_new_game:
                startActivity(new Intent(DashboardActivity.this,SuggestGame.class));

                return true;
            case R.id.menu_log:

                Intent intent=new Intent(DashboardActivity.this,PointsLogActivity.class);
                intent.putExtra("gamee",gamenm);
                intent.putExtra("pts",point);
                intent.putExtra("dt",dt);
                startActivity(intent);

                return true;

            case R.id.menu_logout:
                SharedPreferences pref=getApplicationContext().getSharedPreferences("credentials",MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.remove("username");
                editor.remove("password");
                editor.commit();

                startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
                finish();
                return false;
            case R.id.menu_profile:
                startActivity(new Intent(DashboardActivity.this, GamerProfileActivity.class));

                return  true;
            default:   return super.onOptionsItemSelected(item);
        }

        //}
    }

    private void getlog() {
        AuthenticationApi api=ApiClient.getClient().create(AuthenticationApi.class);

        PointLogInput i=new PointLogInput();
        i.setUserId(FeatureContraoller.getInstance().getUserid());
        i.setOperation("game_logs_show");
        Call<PointLogOuput> call=api.getUserLog(i);
        call.enqueue(new Callback<PointLogOuput>() {
            @Override
            public void onResponse(Call<PointLogOuput> call, Response<PointLogOuput> response) {
                if (response.body().getResponseStatus()==200){
                    log=response.body().getUserProfile();
                    int size=log.size();
                    gamenm=new String[size];
                    point=new String[size];
                    dt=new String[size];
                    int j=0;
                    for (int i=size-1;i>=0;i--){

                        gamenm[j]=log.get(i).getGameName().toString();
                        point[j]=log.get(i).getGainPoints().toString();
                        dt[j]=log.get(i).getDate().toString();
                        j++;


                    }


                }
                else {
                    Toast.makeText(DashboardActivity.this,response.body().getResponseMessage().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PointLogOuput> call, Throwable t) {

            }
        });
    }

//        return super.onOptionsItemSelected(item);
    //  }

    private void getStudentPoints() {
        AuthenticationApi api=ApiClient.getClient().create(AuthenticationApi.class);
        InputPoints i=new InputPoints();
        i.setOperation("gamer_point_count");
        String id= FeatureContraoller.getInstance().getUserid();
        i.setId(id);

        Call<OutputPoints> call=api.getStudentPoints(i);
        call.enqueue(new Callback<OutputPoints>() {
            @Override
            public void onResponse(Call<OutputPoints> call, Response<OutputPoints> response) {
                if (response.body()!=null){
                    if (response.body().getResponseStatus() == 200) {
                        String BrownPoints = response.body().getTotlePoints();
                        float pts=Float.parseFloat(BrownPoints);
                        int point=Math.round(pts);
                        myPoints.setText(""+point);
                        getlog();

                    }
                }
            }

            @Override
            public void onFailure(Call<OutputPoints> call, Throwable t) {

            }
        });


    }

        //startActivity(new Intent(DashboardActivity.this,SuggestGame.class));
    }

