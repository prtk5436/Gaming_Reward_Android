package com.example.gamingrewardandroid.WebServiceClasses;


import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static Retrofit retrofit1 = null;

    static OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(15000, TimeUnit.MICROSECONDS)
            .writeTimeout(15000, TimeUnit.MILLISECONDS)
            .readTimeout(15000, TimeUnit.MILLISECONDS)
            .addInterceptor(new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                   /* .addHeader("Username", "cookiesteam")
                    .addHeader("Password", "L90tkXv6zvSmn4lw7)")*/
                    .build();
            return chain.proceed(request);
        }
    }).build();

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(WebserviceConstant.BASE_URL)
                    //.client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Log.i("BAseUrl", WebserviceConstant.BASE_URL);
        return retrofit;
    }
    public static Retrofit getClient1() {
        if (retrofit1==null) {
            retrofit1 = new Retrofit.Builder()
                    .baseUrl("https://test.smartcookie.in/")
                    //.client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Log.i("BAseUrl", WebserviceConstant.BASE_URL);
        return retrofit1;
    }

}
