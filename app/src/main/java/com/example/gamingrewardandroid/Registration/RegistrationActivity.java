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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.example.gamingrewardandroid.SmartcookieRegistration.SmartcookieRegistration;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;
import com.example.gamingrewardandroid.WebServiceClasses.WebserviceConstant;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
TextView tv1,tvRegister,t2;
Button btnRegistration;
CheckBox csm;
EditText et_name,et_pass,et_mobile, etSchoolId,etemail,edtsmcid,edtsmcpass;
private ProgressBar pBar2;
private RadioGroup rdg_app_type;
private RadioButton rbtn_dev,rbtn_test,rbtn_production;
SharedPreferences.Editor editor;
private SharedPreferences pref;
LinearLayout ll;

private Spinner spintype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegistrationActivity.this, SmartcookieRegistration.class);
                startActivity(i);
            }
        });

 csm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
     @Override
     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
         if(isChecked){
             ll.setVisibility(View.VISIBLE);
         }
         else
         {
             ll.setVisibility(View.GONE);
         }
     }
 });
        if(csm.isChecked())
        {
            ll.setVisibility(View.VISIBLE);
        }
       /* tvRegister=(TextView) findViewById(R.id.tv1);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             Intent i=new Intent(RegistrationActivity.this,LoginActivity.class);
             startActivity(i);
            }
        });*/


        spintype.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) RegistrationActivity.this);
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
        String smcid=edtsmcid.getText().toString();
        String smcpass=edtsmcpass.getText().toString();

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
            } else if (!pass.equals(schoolId)) {
                 Toast.makeText(getApplicationContext(), "Please Enter Same Password and Confirm password", Toast.LENGTH_LONG).show();
            }else if (cattype.equals("Select user Type")) {
                Toast.makeText(getApplicationContext(), "Please Select User Type", Toast.LENGTH_LONG).show();
            }else if (schoolId.equals("")) {
                Toast.makeText(getApplicationContext(), "Please Enter confirm password", Toast.LENGTH_LONG).show();
            } else {
                pBar2.setVisibility(View.VISIBLE);

                StudentRegistrationInput r = new StudentRegistrationInput();
                r.setOperation("gamer_registration");

                r.setPassWord(pass);
                r.setName(name);
                r.setMobileNumber(mobile);

                r.setPlatformForGames("Android");


                r.setEmail(email);
                r.setSmartcookieMemberId(smcid);
                r.setSmc_password(smcpass);


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

                                Toast.makeText(getApplicationContext(), response.body().getResponseMessage().toString(), Toast.LENGTH_LONG).show();
                                finish();
                                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                                startActivity(i);
                            } else
                            {

                                Toast.makeText(getApplicationContext(), response.body().getResponseMessage().toString(), Toast.LENGTH_LONG).show();

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
        etSchoolId=(EditText)findViewById(R.id.et_cnfpass);
        pBar2 = (ProgressBar) findViewById(R.id.pBar2);
        tv1=(TextView)findViewById(R.id.tvlogin);
        spintype=(Spinner) findViewById(R.id.spinner_type);
        rdg_app_type = (RadioGroup) findViewById(R.id.rdg_app_type);
        rbtn_dev = (RadioButton) findViewById(R.id.rbtn_dev);
        rbtn_test = (RadioButton) findViewById(R.id.rbtn_test);
        rbtn_production = (RadioButton) findViewById(R.id.rbtn_production);
        btnRegistration=(Button)findViewById(R.id.btnRegistration);
        edtsmcid=(EditText)findViewById(R.id.et_scmem_id);
        edtsmcpass=findViewById(R.id.et_scmem_pass);
        ll=findViewById(R.id.ll);
        csm=findViewById(R.id.check_smc);
        t2=findViewById(R.id.tv2);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
