package com.example.gamingrewardandroid.Dashboard;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamingrewardandroid.AuthenticationApi;

import com.example.gamingrewardandroid.CommonFunctions;
import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.Model.Post;
import com.example.gamingrewardandroid.Model.Posts1;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.StudentsPoints.InputPoints;
import com.example.gamingrewardandroid.StudentsPoints.OutputPoints;
import com.example.gamingrewardandroid.SuggestGame.SuggestGame;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


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




        myName.setText(FeatureContraoller.getInstance().getFullName());

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
















    private void getStudentPoints() {

       // studentModel = FeatureContraoller.getInstance().getStudentModel().get(0);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        editor = pref.edit();

        String memberID = pref.getString("memberID","");
        String PRN = pref.getString("PRN","");
        String schoolID = pref.getString("schoolID","");


        InputPoints inputPoints = new InputPoints();
        inputPoints.setSchoolId(schoolID);

        inputPoints.setStudentId(Integer.parseInt(PRN));

        inputPoints.setStudentPRN(PRN);

        Log.e("TAG", "Points Input : "+new Gson().toJson(inputPoints) );

        AuthenticationApi authenticationApi = ApiClient.getClient().create(AuthenticationApi.class);
        Call<OutputPoints> call=authenticationApi.getStudentPoints(inputPoints);
        call.enqueue(new Callback<OutputPoints>() {
            @Override
            public void onResponse(Call<OutputPoints> call, Response<OutputPoints> response) {

                Log.e("TAG", "Points Response : "+new Gson().toJson(response.body()) );

                //swipeLayout.setRefreshing(false);
                if(response.body() != null) {
                    if (response.body().getResponseStatus() == 200) {
                        String BrownPoints = response.body().getPosts().get(0).getBrownPoint();
                      myPoints.setText(BrownPoints);
                    } else {
                        CommonFunctions.showToast(response.body().getResponseMessage());
                    }
                }else{
                    CommonFunctions.showToast("Server Error");
                }
            }

            @Override
            public void onFailure(Call<OutputPoints> call, Throwable t) {
                Log.d("myResponse:",  "MSG"+t.toString());
            }
        });
    }

    public void onOption(View view) {
        startActivity(new Intent(DashboardActivity.this,SuggestGame.class));
    }
}
