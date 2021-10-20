package com.servi.reviewerafium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
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
        TextView secs30 = (TextView) findViewById(R.id.secs2);
        ImageView backbut = (ImageView) findViewById(R.id.imageView12);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                secs30.setText(" " + millisUntilFinished / 1000 + " ");
            }

            public void onFinish() {
            }
        }.start();

        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Intent i2 = new Intent(GoodRatingActivity.this, BadCallbackActivity.class);
                startActivity(i2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

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