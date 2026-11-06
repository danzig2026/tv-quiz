package com.example.tvquizlock;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.btn_start);
        Button floatPerm = findViewById(R.id.btn_float);
        Button accPerm = findViewById(R.id.btn_acc);

        floatPerm.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Intent i = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivity(i);
            }
        });
        accPerm.setOnClickListener(v -> {
            Intent i = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(i);
        });

        start.setOnClickListener(v -> {
            startService(new Intent(MainActivity.this, QuizService.class));
            Intent launchVideo = new Intent(Intent.ACTION_VIEW);
            launchVideo.setData(Uri.parse("bilibili://"));
            try {
                startActivity(launchVideo);
            } catch (Exception e) {
            }
        });
    }
}