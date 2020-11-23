package com.example.gamingrewardandroid.SmartcookieRegistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SmartcookieRegistration extends AppCompatActivity {
EditText firstnm,lastnm,midnm,email,pass,phone,ps,schoolid;

TextView type;
Button btnreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartcookie_registration);
        init();
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
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
        btnreg=findViewById(R.id.btn_reg);
    }

}