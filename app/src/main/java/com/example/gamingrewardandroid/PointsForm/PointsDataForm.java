package com.example.gamingrewardandroid.PointsForm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.Dashboard.DashboardActivity;
import com.example.gamingrewardandroid.FeatureContraoller;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.StudentsPoints.Points;
import com.example.gamingrewardandroid.SuggestGame.SuggestGame;
import com.example.gamingrewardandroid.SuggestGame.SuggestGameInput;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.gamingrewardandroid.R.drawable.*;

public class PointsDataForm extends AppCompatActivity {
    public Object[] paramlist;
    LinearLayout gamelayout;
    int size;
    EditText[] param;
    TextView[] txt;
    LinearLayout[] linear;
    ImageView gameimg,screensht;
    String url;
    String gamename;
    String id;
    TextView gamenm;
    String base64String = "";
    private Bitmap bm;
    ProgressBar progressBar;
    byte[] bb = null;
    private String userChoosenTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_data);
        gamelayout=findViewById(R.id.layout_pubg);
        screensht=findViewById(R.id.screenShot);
        gameimg=findViewById(R.id.gameicon);
        gamenm=findViewById(R.id.txt_gamename);
        progressBar=findViewById(R.id.progress);

        url=getIntent().getStringExtra("url");
        gamename=getIntent().getStringExtra("gamename");
        id=getIntent().getStringExtra("gameid");
        gamenm.setText(gamename);
        Glide.with(PointsDataForm.this)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .thumbnail(0.5f)
                .placeholder(R.drawable.images)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(gameimg);

        getParametrs();

    }

    private void setdata() {
       linear=new LinearLayout[size];
       txt=new TextView[size];
       param=new EditText[size];
       for (int i=0;i<size;i++){
           linear[i]=new LinearLayout(this);
           LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
           params.setMargins(5,15,5,15);
           linear[i].setLayoutParams(params);
           linear[i].setOrientation(LinearLayout.HORIZONTAL);


           txt[i]= new TextView(this);
           LinearLayout.LayoutParams param2=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
           param2.setMargins(0,0,10,0);
           txt[i].setLayoutParams(param2);
           txt[i].setText(paramlist[i].toString());
           txt[i].setTextColor(Color.WHITE);
           txt[i].setTextSize(18);

           txt[i].setPadding(30,15,15,15);
           linear[i].addView(txt[i]);



           param[i]=new EditText(this);
           LinearLayout.LayoutParams param1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

           param[i].setLayoutParams(param1);

           param[i].setBackgroundResource(shapeemail);
           param[i].setTextColor(Color.WHITE);
           param[i].setHintTextColor(Color.WHITE);
           param[i].setHint(paramlist[i].toString());
           param[i].setTextSize(20);

           param[i].setPadding(30,15,15,15);
           linear[i].addView(param[i]);

            gamelayout.addView(linear[i]);




       }
/*        for (int i=0;i< size;i++){

            param[i]=new EditText(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 20, 10, 20);

            param[i].setLayoutParams(params);

            param[i].setText(paramlist[i].toString());
            param[i].setBackgroundResource(shapeemail);
            param[i].setTextColor(Color.WHITE);
            param[i].setHintTextColor(Color.WHITE);
            param[i].setHint(paramlist[i].toString());
            param[i].setTextSize(25);

            param[i].setPadding(30,15,15,15);

            gamelayout.addView(param[i]);
        }

*/
    }

    private void getParametrs() {
        AuthenticationApi api= ApiClient.getClient().create(AuthenticationApi.class);
        progressBar.setVisibility(View.VISIBLE);
        RewardParameterInput i=new RewardParameterInput();
        i.setOperation("List_Of_Game_Parameters");
        i.setGameId(id);
        Call<ReawardParameterOutput> call= api.getGameParameterList(i);
        call.enqueue(new Callback<ReawardParameterOutput>() {
            @Override
            public void onResponse(Call<ReawardParameterOutput> call, Response<ReawardParameterOutput> response) {
                if (response.body()!=null){
                    if (response.body().getResponseStatus()==200){
                        progressBar.setVisibility(View.GONE);
                        paramlist= response.body().getGameParametersList().toArray();
                        size = paramlist.length;
                        //Toast.makeText(PointsDataForm.this,"woi",Toast.LENGTH_LONG).show();
                        setdata();
                    }
                }
            }
            @Override
            public void onFailure(Call<ReawardParameterOutput> call, Throwable t) {

            }
        });



    }

    public void onimageupload(View view) { openOptoinDialog();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode==1)
                onSelectFromGalleryResult(data,1);
        }
    }

    private void onSelectFromGalleryResult(Intent data, int i) {
        bm = null;
        if (data != null) {
            try {
                Uri imageUri = data.getData();
                InputStream imageStream = getContentResolver().openInputStream(imageUri);
                bm = BitmapFactory.decodeStream(imageStream);
                bm = getResizedBitmap(bm, 400);
                screensht.setImageBitmap(bm);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        getBase64(bm);

    }
    private String getBase64(Bitmap bm1) {
        if (bm1 != null) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            //  bmap.compress(Bitmap.CompressFormat.PNG, 50, bos);
            bm1.compress(Bitmap.CompressFormat.JPEG, 50, bos);
            bb = bos.toByteArray();
            base64String = Base64.encodeToString(bb, Base64.DEFAULT);
        }
        Log.i("Image", base64String);
        return base64String;
    }

    private Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }


    private void galleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);

    }

    public boolean hasPermissionInManifest(Context context, String permissionName) {
        final String packageName = context.getPackageName();
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
            final String[] declaredPermisisons = packageInfo.requestedPermissions;
            if (declaredPermisisons != null && declaredPermisisons.length > 0) {
                for (String p : declaredPermisisons) {
                    if (p.equals(permissionName)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(); }
        return false;
    }


    private void openOptoinDialog() {
        final CharSequence[] items = { "Choose from Library", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(PointsDataForm.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public void submitScore(View view) {

        progressBar.setVisibility(View.VISIBLE);
        AuthenticationApi api=ApiClient.getClient().create(AuthenticationApi.class);
        AssignPointsInput i=new AssignPointsInput();
        i.setOperation("assign_rewards_use");
        i.setSchoolId("");
        i.setSCMemberID("");
        i.setUserId(FeatureContraoller.getInstance().getUserid());
        i.setMobileNo(FeatureContraoller.getInstance().getUserDetails().get(0).getMobileNumber());
        String img=getBase64(bm);
        i.setImg(img);
            if (id.equals("1") || id.equals("2") || id.equals("3")){
                i.setGameId(id);
                i.setKills(param[0].getText().toString());
                i.setRank(param[1].getText().toString());
                i.setWINOrNot(param[2].getText().toString());
            }else if (id.equals("6") || id.equals("7") ){
                i.setGameId(id);
                i.setDistance(param[0].getText().toString());
                i.setCoinsEarned(param[1].getText().toString());
            }else if (id.equals("4")){

                i.setGameId(id);
                i.setLevel(param[0].getText().toString());
                i.setStars(param[1].getText().toString());
                i.setTrophies(param[2].getText().toString());

            }else if (id.equals("5")){

                i.setGameId(id);
                i.setTotalCoinsEarned(param[0].getText().toString());
                i.setWinnerOn1stRank(param[1].getText().toString());
            }
            else if (id.equals("8")){

                i.setGameId(id);
                i.setLevel(param[0].getText().toString());
                i.setMoves(param[1].getText().toString());


            }else if (id.equals("9")){

                i.setGameId(id);
                i.setScore(param[0].getText().toString());
                i.setStars(param[1].getText().toString());
                i.setLevel(param[2].getText().toString());

            }else if (id.equals("10")){


                i.setGameId(id);
                i.setMoneyWon(param[0].getText().toString());
                i.setRankInCompetition(param[1].getText().toString());
            }

        Call<AssignPointsOutput> call=api.getSelfReward(i);
            call.enqueue(new Callback<AssignPointsOutput>() {
                @Override
                public void onResponse(Call<AssignPointsOutput> call, Response<AssignPointsOutput> response) {
                    if(response.body()!=null){

                        if (response.body().getResponseStatus()==200){

                            Toast.makeText(PointsDataForm.this,response.body().getPointsEarned().toString(),Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            String pts=response.body().getPointsEarned().toString();
                            FeatureContraoller.getInstance().setPoint(pts);
                            Intent intent=new Intent(PointsDataForm.this, PointsEarnedActivity.class);
                            //intent.putExtra(pts,"points");
                            startActivity(intent);

                            //startActivity(new Intent(PointsDataForm.this, PointsEarnedActivity.class));

                        }else {
                            Toast.makeText(PointsDataForm.this,response.body().getResponseMessage(),Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<AssignPointsOutput> call, Throwable t) {

                }
            });

    }
}