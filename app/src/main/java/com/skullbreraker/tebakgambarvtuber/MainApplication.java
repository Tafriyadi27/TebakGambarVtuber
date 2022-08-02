package com.skullbreraker.tebakgambarvtuber;

import android.app.Application;

import com.cloudinary.android.MediaManager;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Cloudinary
        MediaManager.init(this);
    }
}

