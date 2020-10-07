package com.example.gamingrewardandroid.PointsForm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.gamingrewardandroid.R.drawable.*;

public class PointsDataForm extends AppCompatActivity {
    public Object[] paramlist;
    LinearLayout gamelayout;
    int size;
    EditText[] param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_data);

        gamelayout=findViewById(R.id.layout_pubg);
        getParametrs();

    }

    private void setdata() {

        param=new EditText[size];
        for (int i=0;i< size;i++){
            param[i]=new EditText(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 20, 10, 20);

            param[i].setLayoutParams(params);

            param[i].setHint(paramlist[i].toString());
            param[i].setBackgroundResource(shapeemail);
            param[i].setTextColor(Color.WHITE);
            param[i].setHintTextColor(Color.WHITE);
            param[i].setTextSize(25);

            param[i].setPadding(30,15,15,15);

            gamelayout.addView(param[i]);
        }



    }

    private void getParametrs() {
        AuthenticationApi api= ApiClient.getClient().create(AuthenticationApi.class);
        RewardParameterInput i=new RewardParameterInput();
        i.setOperation("List_Of_Game_Parameters");
        i.setGameId("1");
        Call<ReawardParameterOutput> call= api.getGameParameterList(i);
        call.enqueue(new Callback<ReawardParameterOutput>() {
            @Override
            public void onResponse(Call<ReawardParameterOutput> call, Response<ReawardParameterOutput> response) {
                if (response.body()!=null){
                    if (response.body().getResponseStatus()==200){
                        paramlist= response.body().getGameParametersList().toArray();
                        size = paramlist.length;
                        Toast.makeText(PointsDataForm.this,"woi",Toast.LENGTH_LONG).show();
                        setdata();
                    }
                }
            }

            @Override
            public void onFailure(Call<ReawardParameterOutput> call, Throwable t) {

            }
        });



    }
}