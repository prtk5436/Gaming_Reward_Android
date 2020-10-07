package com.example.gamingrewardandroid.LoginStudent;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;
import com.example.gamingrewardandroid.WebServiceClasses.WebserviceConstant;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;

public class LoginActivity extends AppCompatActivity {
    private Button btnlogin;
    private EditText Uname,password,schoolId;
    private ProgressBar pgsBar;
    private SharedPreferences pref;
    private TextView tv1;
    String [] gamename;
    private RadioGroup rdg_app_type;
    SharedPreferences.Editor editor;
    private RadioButton rbtn_dev,rbtn_test,rbtn_production;
    ArrayList <GameList> gameLists=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        editor = pref.edit();
        //Env start
        if(rdg_app_type.getVisibility() == View.VISIBLE) {
            if (pref.getString("apptype", "").equals(WebserviceConstant.TEST)) {
                rbtn_test.setChecked(true);
                WebserviceConstant.setAppType(WebserviceConstant.TEST);
            } else if (pref.getString("apptype", "").equals(WebserviceConstant.PRODUCTION)) {
                rbtn_production.setChecked(true);
                WebserviceConstant.setAppType(WebserviceConstant.PRODUCTION);
            } else if (pref.getString("apptype", "").equals(WebserviceConstant.DEVELOPMENT)) {
                rbtn_dev.setChecked(true);
                WebserviceConstant.setAppType(WebserviceConstant.DEVELOPMENT);
            }
        }else{
            WebserviceConstant.setAppType(WebserviceConstant.PRODUCTION);
        }

        rdg_app_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {

                    case R.id.rbtn_dev:
                        //editor.putString("apptype" ,WebserviceConstant.DEVELOPMENT);
                        WebserviceConstant.setAppType(WebserviceConstant.DEVELOPMENT);
                        break;
                    case R.id.rbtn_test:
                        //editor.putString("apptype" ,WebserviceConstant.TEST);
                        WebserviceConstant.setAppType(WebserviceConstant.TEST);
                        break;
                    case R.id.rbtn_production:
                        //editor.putString("apptype" ,WebserviceConstant.PRODUCTION);
                        WebserviceConstant.setAppType(WebserviceConstant.PRODUCTION);
                        break;
                }
            }
        });
        //Env end

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        String name = pref.getString("username","");
        String school = pref.getString("schoolid","");
        String pass = pref.getString("password","");
        // final String category = pref.getString("category","");
        if( name != null && pass != null && !name.isEmpty() && !pass.isEmpty()){
            tv1.setVisibility(GONE);
            Uname.setVisibility(GONE);
            schoolId.setVisibility(GONE);
            password.setVisibility(GONE);
            btnlogin.setVisibility(GONE);
            pgsBar.setVisibility(View.VISIBLE);
            pgsBar.setVisibility(View.VISIBLE);

            loginStudent(name, school, pass);
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getlistgames();
                String name = Uname.getText().toString().trim();
                String schoolid = schoolId.getText().toString().trim();
                String pass = password.getText().toString().trim();
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGrp);
                // String radiovalue = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();

                /*editor.putString("username", name);
                editor.putString("schoolid", schoolid);
                editor.putString("password", pass);
                editor.commit();
                 */


                if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Phone Number", Toast.LENGTH_LONG).show();
                } else if (schoolid.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter School Id", Toast.LENGTH_LONG).show();
                } else if (pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
                } else{
                    // login1(name,schoolid, pass);
                    loginStudent(name,schoolid, pass);
                    pgsBar.setVisibility(v.VISIBLE);
                }
            }
        });

    }

    private void loginStudent(String name, String schoolid, String pass) {
        pgsBar.setVisibility(View.VISIBLE);
        LoginStudentInput i = new LoginStudentInput();
        i.setCollegeCode(schoolid);
        i.setCountryCode("+91");
        i.setDeviceDetails("");
        i.setDeviceType("android");
        i.setMethod("ANDROID");
        i.setPlatformOS("ANDROID");
        i.setUserName(name);
        i.setUserPass(pass);
        i.setUserType("Mobile-No");

        Log.e("TAG", "response 33: "+new Gson().toJson(i) );

        AuthenticationApi api1 = ApiClient.getClient().create(AuthenticationApi.class);
        Call<LoginStudentOutput> call = api1.getLoginResponse(i);

        call.enqueue(new Callback<LoginStudentOutput>() {
            @Override
            public void onResponse(Call<LoginStudentOutput> call, Response<LoginStudentOutput> response) {
                pgsBar.setVisibility(GONE);
                if(response.body()!= null){
                    if(response.body().getResponseStatus() == 200){

                        Log.e("TAG", "response Login "+new Gson().toJson(response) );

                        //  FeatureContraoller.getInstance().setStudentModel(response.body().getPosts().get(0));

                        FeatureContraoller.getInstance().setFullName(response.body().getPosts().get(0).getFName());
                        FeatureContraoller.getInstance().setMemberId(String.valueOf(response.body().getPosts().get(0).getId()));
                        FeatureContraoller.getInstance().setPRN(response.body().getPosts().get(0).getS_PRN());


                        editor.putString("category", "SmartGamer");
                        editor.putString("fullName",response.body().getPosts().get(0).getFName());
                        editor.putString("PRN",response.body().getPosts().get(0).getS_PRN());
                        editor.putString("schoolID",response.body().getPosts().get(0).getSchoolId());
                        editor.putString("memberID", String.valueOf(response.body().getPosts().get(0).getMemberId()));
                        editor.commit();

                        MyFeatureController.getInstance().setMemberId(response.body().getPosts().get(0).getMemberId());

                        Toast.makeText(getApplicationContext(),"Welcome  "+response.body().getPosts().get(0).getFName(),Toast.LENGTH_LONG).show();

                        Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                        //Intent i = new Intent(LoginActivity.this, PointsDataForm.class);

           //             i.putExtra("gname",gamename);

                        startActivity(i);
                        finish();
                    }else {
                        pgsBar.setVisibility(GONE);
                        //CommonFunctions.showToast(response.body().getResponseMessage());
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginStudentOutput> call, Throwable t) {
                pgsBar.setVisibility(GONE);
                Log.e("error",t.getMessage());

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
    }


}