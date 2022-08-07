package com.skullbreraker.tebakgambarvtuber;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudinary.android.MediaManager;
import com.skullbreraker.tebakgambarvtuber.api.apiendpoint;
import com.skullbreraker.tebakgambarvtuber.api.apiservice;
import com.skullbreraker.tebakgambarvtuber.model.VtuberModel;

import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayActivity extends AppCompatActivity {
    private PlayAdapter playAdapter;
    @NonNull
    public static LevelImages levelImages;
    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        ButterKnife.bind(this);
        levelImages = new LevelImages(this  );
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4, GridLayoutManager.VERTICAL,false));
        playAdapter = new PlayAdapter(this);
        recyclerView.setAdapter(playAdapter);
        ImageView imageView = findViewById(R.id.imageView);
        apiservice api = apiendpoint.getClient().create(apiservice.class);
        api.getImage().enqueue(new Callback<List<VtuberModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<VtuberModel>> call, @NonNull Response<List<VtuberModel>> response) {
                List<VtuberModel> vtuberModels = response.body();
                Log.d("TAG", "onResponse: " + vtuberModels);
                playAdapter.setLevelList(vtuberModels);
            }

            @Override
            public void onFailure(Call<List<VtuberModel>> call, Throwable t) {

            }
        });

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
