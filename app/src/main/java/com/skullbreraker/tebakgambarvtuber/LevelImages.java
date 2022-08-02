package com.skullbreraker.tebakgambarvtuber;


import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.cloudinary.android.MediaManager;

public class LevelImages {
    private final MediaManager mediaManager;


    public LevelImages(Context context) {

        mediaManager = MediaManager.get();

    }

    public String getImgUrl(String level) {
        return mediaManager.url().generate("vtuber/" + level + ".webp");
    }
}
