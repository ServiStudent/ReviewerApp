package com.servi.reviewerafium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
// super.onBackPressed();
// Not calling **super**, disables back button in current screen.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView7);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView9);





        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.imageclick));
                Intent k = new Intent(MainActivity.this, BadRatingActivity.class);
                startActivity(k);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.imageclick));
                Intent k = new Intent(MainActivity.this, BadRatingActivity.class);
                startActivity(k);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.imageclick));
                Intent k = new Intent(MainActivity.this, GoodRatingActivity.class);
                startActivity(k);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.imageclick));
                Intent k = new Intent(MainActivity.this, GoodRatingActivity.class);
                startActivity(k);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.imageclick));
                Locale locale_nl = new Locale("nl");
                Locale.setDefault(locale_nl);
                Configuration config_nl = new Configuration();
                config_nl.locale = locale_nl;
                getBaseContext().getResources().updateConfiguration(config_nl, getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.imageclick));
                Locale locale_en = new Locale("en");
                Locale.setDefault(locale_en);
                Configuration config_en = new Configuration();
                config_en.locale = locale_en;
                getBaseContext().getResources().updateConfiguration(config_en, getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }
}