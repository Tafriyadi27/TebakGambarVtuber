package com.skullbreraker.tebakgambarvtuber;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreditsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits_activity);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnBack)
    void back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
