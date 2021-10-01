package com.servi.reviewerafium;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class BadRatingActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
// super.onBackPressed();
// Not calling **super**, disables back button in current screen.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_rating);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiOptions);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String text = editText5.getText().toString();
                    JavaMailUtil.sendMail("afiumreviewer@gmail.com", text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent i2 = new Intent(BadRatingActivity.this, BadCallbackActivity.class);
                startActivity(i2);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(BadRatingActivity.this, MainActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }
}