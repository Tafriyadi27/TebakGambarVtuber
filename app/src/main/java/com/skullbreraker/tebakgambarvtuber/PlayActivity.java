package com.skullbreraker.tebakgambarvtuber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.android.MediaManager;

import butterknife.ButterKnife;

public class PlayActivity extends AppCompatActivity {
    private PlayAdapter playAdapter;
    @NonNull
    public static LevelImages levelImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        ButterKnife.bind(this);
        levelImages = new LevelImages(this  );
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4, GridLayoutManager.VERTICAL,false));
        playAdapter = new PlayAdapter(this);
        recyclerView.setAdapter(playAdapter);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public static String getUrl(){
        return levelImages.getImgUrl("Kureiji_Ollie");
    }
}
