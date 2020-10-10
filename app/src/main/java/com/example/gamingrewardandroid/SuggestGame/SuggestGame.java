package com.example.gamingrewardandroid.SuggestGame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gamingrewardandroid.AuthenticationApi;
import com.example.gamingrewardandroid.Dashboard.DashboardActivity;
import com.example.gamingrewardandroid.R;
import com.example.gamingrewardandroid.WebServiceClasses.ApiClient;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuggestGame extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 1;
    EditText edt_gamename,edt_param1,edt_param2,edt_param3;
    ImageView gameimg;
    String base64String = "";
    private Bitmap bm;
    byte[] bb = null;
    private String userChoosenTask;
    String param;
    String gamename;
    String img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_game);
        init();
    }

    private void init() {
        edt_gamename=findViewById(R.id.edt_game_name);
        edt_param1=findViewById(R.id.edt_parameter1);
        edt_param2=findViewById(R.id.edt_parameter2);
        edt_param3=findViewById(R.id.edt_parameter3);
        gameimg=findViewById(R.id.screenShot);
    }
    private boolean checkExtPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public void onImageupload(View view) {

            openOptoinDialog();


    }
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            Toast.makeText(getApplicationContext(), "To access Camera permission, Please allow in App Settings for camera functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CODE);
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode==1)
                onSelectFromGalleryResult(data,1);

            //   else if (requestCode == 1)
            //     onCaptureImageResult(data);
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
                gameimg.setImageBitmap(bm);

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
        AlertDialog.Builder builder = new AlertDialog.Builder(SuggestGame.this);
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

    public void onSubmitReq(View view) {
        if (edt_gamename.getText().toString().equals("") || edt_param1.getText().toString().equals("")){
            Toast.makeText(SuggestGame.this,"Please enter game name",Toast.LENGTH_LONG).show();
        }
        else {
          param=edt_param1.getText().toString()+","+edt_param2.getText().toString()+","+edt_param3.getText().toString();
           gamename=edt_gamename.getText().toString();
           img=getBase64(bm);
           submitdata();
        }


    }

    private void submitdata() {
        AuthenticationApi api= ApiClient.getClient().create(AuthenticationApi.class);
        SuggestGameInput i=new SuggestGameInput();
        i.setOperation("Suggest_game_for_rewards");
        i.setGameLogo(img);
        i.setGameParameter(param);
        i.setGameName(gamename);

        Call<SuggestGameOutput> call=api.suggestGame(i);
        call.enqueue(new Callback<SuggestGameOutput>() {
            @Override
            public void onResponse(Call<SuggestGameOutput> call, Response<SuggestGameOutput> response) {
                if (response.body()!=null){
                    if (response.body().getResponseStatus()==200){
                        Toast.makeText(SuggestGame.this,response.body().getResponseMessage(),Toast.LENGTH_LONG).show();
                            startActivity(new Intent(SuggestGame.this, DashboardActivity.class));
                            finish();
                    }else {
                        Toast.makeText(SuggestGame.this,response.body().getResponseMessage(),Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(SuggestGame.this,"Server Error",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<SuggestGameOutput> call, Throwable t) {

            }
        });
    }
}