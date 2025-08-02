package com.application.minipocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserSignUp extends AppCompatActivity {
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        getSupportActionBar().hide();

        TextView loginbt = (TextView) findViewById(R.id.loginlink);
        Button signBt = (Button) findViewById(R.id.signBt);
        final EditText emailt = (EditText) findViewById(R.id.emailIdt);
        final EditText namet = (EditText) findViewById(R.id.Namet);
        final EditText phonet = (EditText) findViewById(R.id.Phonet);
        final EditText loct = (EditText) findViewById(R.id.loct);
        final EditText passt = (EditText) findViewById(R.id.Passt);
        final EditText conpasst = (EditText) findViewById(R.id.Conpasst);


        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserSignUp.this, UserLogin.class);
                startActivity(i);
            }
        });


        signBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailt.getText().toString().equals("") || namet.getText().toString().equals("") || phonet.getText().toString().equals("") || loct.getText().toString().equals("") || passt.getText().toString().equals("") || conpasst.getText().toString().equals("")) {
                    Toast.makeText(UserSignUp.this, "Please fill all fields to continue", Toast.LENGTH_SHORT).show();
                } else {
                    String email = emailt.getText().toString();
                    String name = namet.getText().toString();
                    String phone = phonet.getText().toString();
                    String location = loct.getText().toString();
                    String pass = passt.getText().toString();
                    String conpass = conpasst.getText().toString();

                    if (pass.length() < 6) {
                        Toast.makeText(UserSignUp.this, "Password must be of minimum 6 characters", Toast.LENGTH_SHORT).show();
                    } else if (!pass.equals(conpass)) {
                        Toast.makeText(UserSignUp.this, "Passwords does not match", Toast.LENGTH_SHORT).show();
                    } else {
                        mRequestQueue = Volley.newRequestQueue(UserSignUp.this);
                        // Progress

                        mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i("tagconvertstrUser", "[" + response + "]");
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String success = jsonObject.getString("success");
                                    String message = jsonObject.getString("message");


                                    Toast.makeText(UserSignUp.this, message, Toast.LENGTH_LONG).show();

                                    if (success.equals("1")) {

                                        Toast.makeText(UserSignUp.this, "You can login now!", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(UserSignUp.this, UserLogin.class);
                                        startActivity(i);
                                        finish();

                                    }

                                } catch (JSONException e) {

                                    Toast.makeText(UserSignUp.this, e.toString(), Toast.LENGTH_LONG).show();
                                    Log.d("error1 ", e.toString());

                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(UserSignUp.this, error.toString(), Toast.LENGTH_LONG).show();
                                Log.d("error2 ", error.toString());

                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {

                                Map<String, String> params = new HashMap<>();
                                params.put("name", name);
                                params.put("email", email);
                                params.put("location", location);
                                params.put("phone", phone);
                                params.put("password", pass);

                                return params;
                            }
                        };

                        mStringRequest.setShouldCache(false);
                        mRequestQueue.add(mStringRequest);
                    }
                }
            }
        });

    }

    private String getBaseUrl() {
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/MiniPocket/user_signup.php";
    }
}
