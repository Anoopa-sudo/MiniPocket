package com.application.minipocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        Button logout = (Button) findViewById(R.id.logoutBt);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = MainActivity.shared.edit();
                editor.clear();
                editor.commit();
                Log.e("Logged out", "Logged out");
                Intent i=new Intent(UserDashboard.this,Home.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void handleButtonClick(View view) {
        String parameter = "com.application.minipocket."+view.getTag().toString()+"_listing";
        Log.i("Service Button Test",parameter);
        try {
            Class<?> activityClass = Class.forName(parameter);
            Intent i = new Intent(UserDashboard.this, activityClass);
//            i.putExtra("user",idKey);
            startActivity(i);
        } catch (ClassNotFoundException e) {
            Log.e("Navigation Error", "Screen not found: " + e);
        }
    }

}