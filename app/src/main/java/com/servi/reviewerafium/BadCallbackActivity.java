package com.servi.reviewerafium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class BadCallbackActivity extends AppCompatActivity {
Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_callback);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i5 = new Intent(BadCallbackActivity.this, MainActivity.class);
                startActivity(i5);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        }, 5000);
    }
}