package com.example.gamingrewardandroid.Registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.LoginStudent.LoginActivity;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;
import com.example.gamingrewardandroid.WebServiceClasses.WebserviceConstant;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
TextView tv1,tvRegister;
Button btnRegistration;
EditText et_name,et_pass,et_mobile, etSchoolId,etemail;
private ProgressBar pBar2;
private RadioGroup rdg_app_type;
private RadioButton rbtn_dev,rbtn_test,rbtn_production;
SharedPreferences.Editor editor;
private SharedPreferences pref;
private Spinner spintype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();

       /* tvRegister=(TextView) findViewById(R.id.tv1);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             Intent i=new Intent(RegistrationActivity.this,LoginActivity.class);
             startActivity(i);
            }
        });*/


        spintype.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spectator_type, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spintype.setAdapter(adapter);;

        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        editor = pref.edit();
        //Env start
        if(rdg_app_type.getVisibility() == View.VISIBLE) {
            if (pref.getString("apptype","").equals(WebserviceConstant.TEST)) {
                rbtn_test.setChecked(true);
                WebserviceConstant.setAppType(WebserviceConstant.TEST);
            } else if (pref.getString("apptype","").equals(WebserviceConstant.PRODUCTION)) {
                rbtn_production.setChecked(true);
                WebserviceConstant.setAppType(WebserviceConstant.PRODUCTION);
            }else if (pref.getString("apptype","").equals(WebserviceConstant.DEVELOPMENT)) {
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
                        editor.putString("apptype" ,WebserviceConstant.DEVELOPMENT);
                        WebserviceConstant.setAppType(WebserviceConstant.DEVELOPMENT);
                        break;

                    case R.id.rbtn_test:
                        editor.putString("apptype" ,WebserviceConstant.TEST);
                        WebserviceConstant.setAppType(WebserviceConstant.TEST);
                        break;

                    case R.id.rbtn_production:
                        editor.putString("apptype" ,WebserviceConstant.PRODUCTION);
                        WebserviceConstant.setAppType(WebserviceConstant.PRODUCTION);
                        break;
                }
            }
        });
        //Env end


        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registration();

            }
        });



        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

    private void registration() {


        String name = et_name.getText().toString().trim();
        String email = etemail.getText().toString().trim();
        String pass = et_pass.getText().toString().trim();
        String mobile = et_mobile.getText().toString();
        String schoolId = etSchoolId.getText().toString();

        //String cattype=spintype.getSelectedItem().toString();

        String cattype= "Player";

        if (!isValidMobile(mobile)|| mobile.length()!=10|| mobile.startsWith("1")|| mobile.startsWith("2")|| mobile.startsWith("3")|| mobile.startsWith("4")|| mobile.startsWith("5")|| mobile.startsWith("0")){
            Toast.makeText(getApplicationContext(), "Please Enter valide Mobile Number", Toast.LENGTH_LONG).show();
        }
        else

               /*if(cattype=="Select Type"){
                   Toast.makeText(getApplicationContext(), "Please Select Type", Toast.LENGTH_LONG).show();
               }*/
            // Log.e("type",cattype.toString());
            if (name.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_LONG).show();
            } else if (mobile.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter Mobile Number", Toast.LENGTH_LONG).show();
            }
            else if (pass.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
            }   else if (cattype.equals("Select user Type")) {
                Toast.makeText(getApplicationContext(), "Please Select User Type", Toast.LENGTH_LONG).show();
            }else if (schoolId.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter School Id", Toast.LENGTH_LONG).show();
            } else
            {
                pBar2.setVisibility(View.VISIBLE);
               /* InputParameterRegister r = new InputParameterRegister();
                r.setMobile(mobile);
                r.setSchool_id(schoolId);
                r.setPassword(pass);
                r.setUser_name(name);
                r.setCategory(cattype);  */

                StudentRegistrationInput r = new StudentRegistrationInput();
                r.setPhonenumber(mobile);
                r.setSchoolId(schoolId);
                r.setPassword(pass);
                r.setFirstname(name);
                r.setType("student");
                r.setPlatformSource("Android");
                r.setMiddlename("");
                r.setCountrycode("91");
                r.setEmailid(email);
                r.setLastname(".");


                Log.e("TAG", "registration input: "+new Gson().toJson(r) );

                AuthenticationApi api = ApiClient.getClient().create(AuthenticationApi.class);
                Call<StudentRegistraionOutput> call = api.getRegisterResponse(r);
                call.enqueue(new Callback<StudentRegistraionOutput>() {
                    @Override
                    public void onResponse(Call<StudentRegistraionOutput> call, Response<StudentRegistraionOutput> response) {
                        pBar2.setVisibility(View.GONE);

                        if(response.body()!= null){
                            if (response.body().getResponseStatus().equals(200))
                            {

                                Toast.makeText(getApplicationContext(), " Registered Successfully ", Toast.LENGTH_LONG).show();
                                finish();
                                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                                startActivity(i);
                            } else if(response.body().getResponseStatus().equals(409))
                            {
                                Toast.makeText(getApplicationContext(), "User Already Exist", Toast.LENGTH_LONG).show();
                            } else if(response.body().getResponseStatus().equals(1000)){
                                Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_LONG).show();
                            }else if(response.body().getResponseStatus().equals(409)){
                                Toast.makeText(getApplicationContext(), "Please Enter Valid School Id", Toast.LENGTH_LONG).show();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<StudentRegistraionOutput> call, Throwable t) {
                        pBar2.setVisibility(View.GONE);
                    }
                });

            }

    }

    private boolean isValidMobile(String mobile) {
        if (!TextUtils.isEmpty(mobile)) {
            return Patterns.PHONE.matcher(mobile).matches();
        }
        return false;
    }
    private void init() {
        et_name=(EditText)findViewById(R.id.et_name);
        etemail=(EditText)findViewById(R.id.etemail);
        et_pass=(EditText)findViewById(R.id.et_pass);
        et_mobile=(EditText)findViewById(R.id.et_mobile);
        etSchoolId=(EditText)findViewById(R.id.etSchoolId);
        pBar2 = (ProgressBar) findViewById(R.id.pBar2);
        tv1=(TextView)findViewById(R.id.tvlogin);
        spintype=(Spinner) findViewById(R.id.spinner_type);
        rdg_app_type = (RadioGroup) findViewById(R.id.rdg_app_type);
        rbtn_dev = (RadioButton) findViewById(R.id.rbtn_dev);
        rbtn_test = (RadioButton) findViewById(R.id.rbtn_test);
        rbtn_production = (RadioButton) findViewById(R.id.rbtn_production);
        btnRegistration=(Button)findViewById(R.id.btnRegistration);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
