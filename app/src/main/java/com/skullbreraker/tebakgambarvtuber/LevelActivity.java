package com.skullbreraker.tebakgambarvtuber;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cloudinary.android.MediaManager;
import com.skullbreraker.tebakgambarvtuber.api.apiendpoint;
import com.skullbreraker.tebakgambarvtuber.api.apiservice;
import com.skullbreraker.tebakgambarvtuber.model.ConfirmModel;
import com.skullbreraker.tebakgambarvtuber.model.VtuberModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LevelActivity extends AppCompatActivity {

    PlayActivity playActivity = new PlayActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
//        ButterKnife.bind(this);

        Toolbar childToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(childToolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        level();

        EditText editText = findViewById(R.id.editText);
        Button btnSubmit = findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jawaban = editText.getText().toString();
                apiservice api = apiendpoint.getClient().create(apiservice.class);
                api.confirmVtuber(jawaban).enqueue(new Callback<ConfirmModel>() {
                    @Override
                    public void onResponse(Call<ConfirmModel> call, Response<ConfirmModel> response) {
                        ConfirmModel confirmModel = response.body();
                        if (confirmModel.getStatus().equals("success")){
                            final Dialog dialog = new Dialog(LevelActivity.this);
                            dialog.setContentView(R.layout.correct_dialog);
                            dialog.show();
                            new Handler().postDelayed(dialog::dismiss, 1000);
                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialogInterface) {
                                    Intent intent = new Intent(LevelActivity.this, PlayActivity.class);
                                    startActivity(intent);
                                    }
                            });
                            TextView textView = dialog.findViewById(R.id.textView2);
                            textView.setText(confirmModel.getMessage());
                        } else if (confirmModel.getStatus().equals("failed")){
                            final Dialog dialog = new Dialog(LevelActivity.this);
                            dialog.setContentView(R.layout.incorrect_dialog);
                            dialog.show();
                            new Handler().postDelayed(dialog::dismiss, 1000);
                            TextView textView = dialog.findViewById(R.id.textView2);
                            textView.setText(confirmModel.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<ConfirmModel> call, Throwable t) {

                    }
                });
            }
        });

    }


//    @OnClick(R.id.imageView)
//    void back() {
//        Intent intent = new Intent(this, PlayActivity.class);
//        startActivity(intent);
//        finish();
//    }

    public void level() {
        Intent intent = getIntent();
        String level = intent.getStringExtra("level");
        String images = intent.getStringExtra("images");
        TextView textView = findViewById(R.id.textView2);
        textView.setText("LEVEL " + level);
        ImageView imageView = findViewById(R.id.vtuberimages);
        Glide.with(this).load(images).placeholder(R.drawable.ic_baseline_image_24).into(imageView);
    }
}