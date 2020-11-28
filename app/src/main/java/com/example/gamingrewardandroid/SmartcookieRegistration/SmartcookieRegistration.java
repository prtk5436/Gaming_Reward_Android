package com.example.gamingrewardandroid.SmartcookieRegistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.LoginStudent.LoginActivity;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.Registration.RegistrationActivity;
import com.example.gamingrewardandroid.Registration.StudentRegistraionOutput;
import com.example.gamingrewardandroid.Registration.StudentRegistrationInput;
import com.example.gamingrewardandroid.SmartcookieRegistration.SchoolidValidation.SchoolidInput;
import com.example.gamingrewardandroid.SmartcookieRegistration.SchoolidValidation.SchoolidOutput;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;
import com.example.gamingrewardandroid.WebServiceClasses.WebserviceConstant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SmartcookieRegistration extends AppCompatActivity {
EditText firstnm,lastnm,midnm,email,pass,phone,ps,schoolid;

TextView type;
Button btn_reg,btn_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartcookie_registration);
        init();
        schoolid.setEnabled(true);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        btn_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    public void validate() {
        WebserviceConstant.setAppType(WebserviceConstant.TEST);
        SchoolidInput sc=new SchoolidInput();
        sc.setSchoolId(schoolid.getText().toString().trim());
        AuthenticationApi api=ApiClient.getClient().create(AuthenticationApi.class);
        Call<SchoolidOutput> call=api.schoolId(sc);
        call.enqueue(new Callback<SchoolidOutput>() {
            @Override
            public void onResponse(Call<SchoolidOutput> call, Response<SchoolidOutput> response) {
                if(response.body()!=null)
                {

                    if (response.body().getResponseStatus().equals(200))
                    {
                       Toast.makeText(getApplicationContext(),"Valid School Id", Toast.LENGTH_LONG).show();
                       schoolid.setEnabled(false);
                        //Log.i("DATA","Successfull");
                    }
                    else if (response.body().getResponseStatus().equals(204)){
                        Toast.makeText(getApplicationContext(),"invalid",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SchoolidOutput> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Invalid School Id",Toast.LENGTH_LONG).show();
            }
        });

    }


private void register() {
        SmcInput s = new SmcInput();
       s.setFirstname(firstnm.getText().toString());
       s.setLastname(lastnm.getText().toString());
       s.setMiddlename(midnm.getText().toString());
       s.setType("student");
       s.setEmailid(email.getText().toString());
       s.setPassword(pass.getText().toString());
       s.setPhonenumber(phone.getText().toString());
       s.setCountrycode("91");
       s.setPlatformSource("Andriod");
       s.setSchoolId(schoolid.getText().toString());
        AuthenticationApi api = ApiClient.getClient().create(AuthenticationApi.class);
        Call<SmcOutput> call = api.smc(s);
        call.enqueue(new Callback<SmcOutput>() {
            @Override
            public void onResponse(Call<SmcOutput> call, Response<SmcOutput> response) {
                if(response.body()!= null){
                    if (response.body().getResponseStatus().equals(200))
                    {

                        Toast.makeText(getApplicationContext(), response.body().getResponseMessage().toString(), Toast.LENGTH_LONG).show();
                        finish();
                        Intent i = new Intent(SmartcookieRegistration.this, RegistrationActivity.class);
                        startActivity(i);
                    } else
                    {

                        Toast.makeText(getApplicationContext(), response.body().getResponseMessage().toString(), Toast.LENGTH_LONG).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<SmcOutput> call, Throwable t) {

            }
        });

    }


    private void init() {
        firstnm=findViewById(R.id.edt_firstnm);
        lastnm=findViewById(R.id.edt_lastnm);
        midnm=findViewById(R.id.edt_midnm);
        type=findViewById(R.id.txt_type);
        email=findViewById(R.id.edt_emailid);
        pass=findViewById(R.id.edt_password);
        phone=findViewById(R.id.edt_phoneno);
        ps=findViewById(R.id.edt_ps);
        schoolid=findViewById(R.id.edt_schoolid);
        btn_reg=findViewById(R.id.btn_reg);
        btn_val=findViewById(R.id.btn_val);
    }

}