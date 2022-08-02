package com.skullbreraker.tebakgambarvtuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cloudinary.android.MediaManager;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        ButterKnife.bind(this);
        level();
    }


    @OnClick(R.id.imageView)
    void back() {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
        finish();
    }

    public void level() {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("LEVEL " + level);

        String url = MediaManager.get().url().generate("vtuber/Kureiji_Ollie.webp");
        ImageView imageView = findViewById(R.id.vtuberimages);
        Glide.with(this).load(url).into(imageView);
    }
}