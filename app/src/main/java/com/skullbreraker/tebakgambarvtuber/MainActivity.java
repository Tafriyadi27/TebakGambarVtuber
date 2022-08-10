package com.skullbreraker.tebakgambarvtuber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindString(R.string.exit_confirm)
    String emptyMessage;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnexit = findViewById(R.id.btnexit);
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        String user = sharedPreferences.getString("user", "");
        if (user.isEmpty()) {
            TextView textView = findViewById(R.id.txtUser);
            textView.setText("Nama User : Guest");
        } else
        {
            TextView textView = findViewById(R.id.txtUser);
            textView.setText("Nama User : " + user);
        }
        ButterKnife.bind(this);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnplay)
    void play() {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btnoptions)
    void options() {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btncredits)
    void credits() {
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    }
    public void exit() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.exit_dialog);

        // set the custom dialog components - text, image and button
        TextView text = dialog.findViewById(R.id.confirmText);
        Button yesButton = dialog.findViewById(R.id.btnYes);
        Button noButton = dialog.findViewById(R.id.btnNo);

        text.setText(emptyMessage);

        // if button is clicked, close the custom dialog
        yesButton.setOnClickListener(v -> {dialog.dismiss();
        finishAffinity();});
        noButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}