package com.example.gamingrewardandroid.LeaderBoard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoard extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Top5GamerName> leaders;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        getLeader();
    }

    private void getLeader() {
        AuthenticationApi api= ApiClient.getClient().create(AuthenticationApi.class);
        LeaderBoardInput i=new LeaderBoardInput();
        i.setOperation("leader_board");
        i.setType("week");
        Call<LeaderBoardOutput> call=api.getLeader(i);
        call.enqueue(new Callback<LeaderBoardOutput>() {
            @Override
            public void onResponse(Call<LeaderBoardOutput> call, Response<LeaderBoardOutput> response) {
                if (response.body().getResponseStatus()==200){
                    leaders=response.body().getTop5GamerName();
                    recyclerView=findViewById(R.id.leaderrecycle);
                    recyclerView.setLayoutManager(new LinearLayoutManager(LeaderBoard.this));
                    recyclerView.setHasFixedSize(true);
                    LeaderAdaptor adaptor=new LeaderAdaptor(leaders,LeaderBoard.this);
                    recyclerView.setAdapter(adaptor);

                }
            }

            @Override
            public void onFailure(Call<LeaderBoardOutput> call, Throwable t) {

            }
        });

    }
}