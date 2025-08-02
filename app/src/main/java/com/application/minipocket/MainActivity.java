package com.application.minipocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT=1000;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static final String role = "roleKey";
    public static SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                shared = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                String roleKey = (shared.getString(role, ""));
                String idKey = (shared.getString(userid, ""));

                if(roleKey.equals("")) {
                    Intent i = new Intent(MainActivity.this, Home.class);
                    startActivity(i);
                    finish();
                }
                else if(roleKey.equals("User")) {
                    Intent i = new Intent(MainActivity.this, UserDashboard.class);
                    i.putExtra("user",idKey);
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}