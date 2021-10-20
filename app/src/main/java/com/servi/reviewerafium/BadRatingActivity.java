package com.servi.reviewerafium;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class BadRatingActivity extends AppCompatActivity {
    private int time = 10000;

    @Override
    public void onBackPressed() {
// super.onBackPressed();
// Not calling **super**, disables back button in current screen.
    }
    Handler handler;
    Runnable r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_rating);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EditText editText5 = (EditText) findViewById(R.id.editText5);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                Intent i5 = new Intent(BadRatingActivity.this, MainActivity.class);
                startActivity(i5);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        };

        editText5.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                startHandler(300);
                System.out.println("Started");
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                stopHandler();
                System.out.println("Stopped");
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

        startHandler(0);

        button3.setOnClickListener(new View.OnClickListener() {
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
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(BadRatingActivity.this, MainActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        editText5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });


    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public void stopHandler() {
        handler.removeCallbacks(r);
    }
    public void startHandler(int a) {
        time += a;
        handler.postDelayed(r, time);
        System.out.println(time);
    }
}