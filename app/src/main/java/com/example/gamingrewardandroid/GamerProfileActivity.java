package com.example.gamingrewardandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class GamerProfileActivity extends AppCompatActivity {
EditText edt_name,edt_phone,edt_email,edt_pass,edt_add,edt_city,edt_state,edt_country;
Button btn_update;
String str_name,str_phone,str_email,str_pass,str_add,str_city,str_state,str_country;
ImageView btn_edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamer_profile);
        init();
        editoff();
    }

    private void editoff() {
        edt_name.setEnabled(false);
        edt_phone.setEnabled(false);
        edt_email.setEnabled(false);
        edt_pass.setEnabled(false);
        edt_add.setEnabled(false);
        edt_city.setEnabled(false);
        edt_state .setEnabled(false);
        edt_country.setEnabled(false);
        btn_update.setVisibility(View.GONE);
    }

    private void init() {
        edt_name=findViewById(R.id.edt_gamername);
        edt_phone=findViewById(R.id.edt_gamerphone);
        edt_email=findViewById(R.id.edt_gameremail);
        edt_pass=findViewById(R.id.edt_gamerpass);
        edt_add=findViewById(R.id.edt_gameradd);
        edt_city=findViewById(R.id.edt_gamercity);
        edt_state=findViewById(R.id.edt_gamerstate);
        edt_country=findViewById(R.id.edt_gamercountry);
        btn_update=findViewById(R.id.btn_update);
        btn_edt=findViewById(R.id.btn_edt);

    }

    public void onUpdate(View view) {
        str_name=edt_name.getText().toString();
        str_phone=edt_phone.getText().toString();
    str_email=edt_email.getText().toString();
    str_pass=edt_pass.getText().toString();
    str_add=edt_add.getText().toString();
    str_city=edt_city.getText().toString();
    str_state=edt_state.getText().toString();
    str_country=edt_country.getText().toString();
    onProfileUpdate();
    }

    private void onProfileUpdate() {

    }

    public void btnEdit(View view) {
        edt_name.setEnabled(true);
        edt_phone.setEnabled(true);
        edt_email.setEnabled(true);
        edt_pass.setEnabled(true);
        edt_add.setEnabled(true);
        edt_city.setEnabled(true);
        edt_state .setEnabled(true);
        edt_country.setEnabled(true);
        btn_update.setVisibility(View.VISIBLE);
    }

    }
