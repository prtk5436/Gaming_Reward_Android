package com.example.gamingrewardandroid.LoginStudent;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.Dashboard.DashboardActivity;
import com.example.gamingrewardandroid.Dashboard.GameList;
import com.example.gamingrewardandroid.Dashboard.GameListInput;
import com.example.gamingrewardandroid.Dashboard.GameListOutput;
import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.MyFeatureController;
import com.example.gamingrewardandroid.PointsForm.PointsDataForm;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.Registration.RegistrationActivity;
import com.example.gamingrewardandroid.SplashScreen;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;
import com.example.gamingrewardandroid.WebServiceClasses.WebserviceConstant;
import com.google.gson.Gson;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;
import static com.example.gamingrewardandroid.MainApplication.getContext;

public class LoginActivity extends AppCompatActivity {
    private Button btnlogin;
    private EditText Uname,password,schoolId;
    private ProgressBar pgsBar;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    private TextView tv1,vcode;
    String [] gamename;
    private RadioGroup rdg_app_type;
    String uname,pass;
    public  ArrayList<UserDetail> userDetails;
    private RadioButton rbtn_dev,rbtn_test,rbtn_production;
    ArrayList <GameList> gameLists=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        //CheckUPdate();

        PackageInfo pinfo = null;
        try {
            pinfo = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String name = pinfo.versionName;
        vcode.setText("Application Version : " + name);


        pref=getApplicationContext().getSharedPreferences("credentials",MODE_PRIVATE);
        editor=pref.edit();
        uname= pref.getString("username","");
        pass=pref.getString("password","");
        if (!uname.isEmpty() && !pass.isEmpty()){
            loginStudent(uname,pass);
            getlistgames();
        }


        //pref = getSharedPreferences("user_details",MODE_PRIVATE);
        //editor = pref.edit();

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getlistgames();
                String name = Uname.getText().toString().trim();

                String pass = password.getText().toString().trim();





                if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Phone Number", Toast.LENGTH_LONG).show();
                } else if (pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                } else{
                    // login1(name,schoolid, pass);
                    loginStudent(name, pass);
                    pgsBar.setVisibility(v.VISIBLE);
                }
            }
        });

    }

    private void loginStudent(final String name, final String pass) {
        AuthenticationApi api=ApiClient.getClient().create(AuthenticationApi.class);
        LoginInput i=new LoginInput();
        i.setOperation("gamer_login");
        i.setMobileNumber(name);
        i.setEmail("");
        i.setPassWord(pass);
        Call<LoginOutput> call=api.getlogin(i);
        call.enqueue(new Callback<LoginOutput>() {
            @Override
            public void onResponse(Call<LoginOutput> call, Response<LoginOutput> response) {
                if (response.body()!=null){
                    if (response.body().getResponseStatus()==200){


                            userDetails= (ArrayList<UserDetail>) response.body().getUserDetails();
                            editor.putString("username",name);
                            editor.putString("password",pass);
                            editor.commit();
                            FeatureContraoller.getInstance().setUserid(userDetails.get(0).getId());
                            FeatureContraoller.getInstance().setUserDetails((ArrayList<UserDetail>) response.body().getUserDetails());
                        Toast.makeText(LoginActivity.this,response.body().getResponseMessage().toString(),Toast.LENGTH_LONG).show();

                        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
                        pgsBar.setVisibility(GONE);
                            finish();

                    }else {
                        Toast.makeText(LoginActivity.this,response.body().getResponseMessage().toString(),Toast.LENGTH_LONG).show();
                        pgsBar.setVisibility(GONE);

                    }
                }
            }

            @Override
            public void onFailure(Call<LoginOutput> call, Throwable t) {

            }
        });
    }

    private void getlistgames() {
        AuthenticationApi api=ApiClient.getClient().create(AuthenticationApi.class);
        GameListInput i=new GameListInput();
        i.setOperation("List_of_Game");
        Call<GameListOutput> call=api.getgamelist(i);
        call.enqueue(new Callback<GameListOutput>() {
            @Override
            public void onResponse(Call<GameListOutput> call, Response<GameListOutput> response) {
                if (response.body()!=null){
                    if (response.body().getResponseStatus()==200){
                        gameLists= (ArrayList<GameList>) response.body().getGameList();
                        int i=gameLists.size();
                        gamename=new String[i];
                        for (int j=0;j<i;j++){
                            gamename[j]=gameLists.get(j).getGameName().toString();

                        }
                        FeatureContraoller.getInstance().setGamename(gamename);
                        FeatureContraoller.getInstance().setGamelist((ArrayList<GameList>) response.body().getGameList());

                    }else {
                        Toast.makeText(getApplicationContext(),"game",Toast.LENGTH_LONG);
                    }
                }
            }

            @Override
            public void onFailure(Call<GameListOutput> call, Throwable t) {

            }
        });

    }

    private void init() {
        Uname=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        schoolId=(EditText)findViewById(R.id.schoolId);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        pgsBar = (ProgressBar) findViewById(R.id.pBar);
        tv1=(TextView)findViewById(R.id.tv1);
        RadioButton radio1=(RadioButton)findViewById(R.id.radio1);
        RadioButton radio2=(RadioButton)findViewById(R.id.radio2);
        rdg_app_type = (RadioGroup) findViewById(R.id.rdg_app_type);
        rbtn_dev = (RadioButton) findViewById(R.id.rbtn_dev);
        rbtn_test = (RadioButton) findViewById(R.id.rbtn_test);
        rbtn_production = (RadioButton) findViewById(R.id.rbtn_production);
        vcode=findViewById(R.id.edt_verno);
    }

//update version
    @SuppressLint("StaticFieldLeak")
    public class VersionChecker extends AsyncTask<String, String, String> {
        private String newVersion;
        @Override
        protected String doInBackground(String... params) {

            try {
                newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id="+getPackageName())
                        .timeout(30000)
                        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                        .referrer("http://www.google.com")
                        .get()
                        .select(".hAyfc .htlgb")
                        .get(7)
                        .ownText();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return newVersion;
        }
    }
    private void CheckUPdate() {
        LoginActivity.VersionChecker versionChecker = new VersionChecker();
        try
        {
            // String appVersionName = BuildConfig.VERSION_NAME;
            PackageInfo pinfo = null;
            try {
                pinfo = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            String name = pinfo.versionName;
            String mLatestVersionName = versionChecker.execute().get();
            Integer i=name.compareTo(mLatestVersionName);
            System.out.println(name);
            System.out.println(mLatestVersionName);
            System.out.println(i);


            if(i<0){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginActivity.this);
                alertDialog.setTitle("Please update your app");
                alertDialog.setCancelable(true);
                alertDialog.setMessage("This app version is no longer supported. Please update your app from the Play Store.");
                alertDialog.setPositiveButton("UPDATE NOW", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        final String appPackageName = getPackageName();
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                });
               /* alertDialog.setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });*/
                alertDialog.show();
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }




}