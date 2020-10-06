package com.example.gamingrewardandroid;


import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {
    private static Context _context;

    public static Context getContext() {
        return _context;
    }

    public static void setContext(Context context) {
        _context = context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Fabric.with(this, new Crashlytics());
        _context = this;
    }
}
