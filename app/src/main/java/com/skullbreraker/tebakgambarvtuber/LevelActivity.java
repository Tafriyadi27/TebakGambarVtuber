package com.skullbreraker.tebakgambarvtuber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.imageView)
    void back() {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}