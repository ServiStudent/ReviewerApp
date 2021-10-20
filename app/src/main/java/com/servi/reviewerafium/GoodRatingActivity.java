package com.servi.reviewerafium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GoodRatingActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
// super.onBackPressed();
// Not calling **super**, disables back button in current screen.
    }
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_rating);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);
        TextView secs30 = (TextView) findViewById(R.id.secs2);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                secs30.setText(" " + millisUntilFinished / 1000 + " ");
            }

            public void onFinish() {
            }
        }.start();


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i4 = new Intent(GoodRatingActivity.this, MainActivity.class);
                startActivity(i4);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        }, 30000);
    }

}