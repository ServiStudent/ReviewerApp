package com.servi.reviewerafium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class GoodCallbackActivity extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_callback);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);
        timer = new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i5 = new Intent(GoodCallbackActivity.this, MainActivity.class);
                startActivity(i5);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        }, 10000);
    }
}