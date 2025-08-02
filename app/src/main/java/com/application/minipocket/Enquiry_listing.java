package com.application.minipocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Enquiry_listing extends AppCompatActivity {
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static SharedPreferences shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        getSupportActionBar().hide();

        Button backBt = (Button) findViewById(R.id.backBt);
        Button sendBt = (Button) findViewById(R.id.sendBt);
        final EditText subt = (EditText) findViewById(R.id.subt);
        final EditText msgt = (EditText) findViewById(R.id.msgt);

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Enquiry_listing.this, UserDashboard.class);
                startActivity(i);
                finish();

            }
        });

        sendBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subt.getText().toString().equals("") || msgt.getText().toString().equals("")) {
                    Toast.makeText(Enquiry_listing.this, "Please fill all fields to continue", Toast.LENGTH_SHORT).show();
                } else {
                    String sub = subt.getText().toString();
                    String msg = msgt.getText().toString();



                    mRequestQueue = Volley.newRequestQueue(Enquiry_listing.this);
                    // Progress

                    mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("tagconvertstrEnquiry", "[" + response + "]");
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("success");
                                String message = jsonObject.getString("message");


                                Toast.makeText(Enquiry_listing.this, message, Toast.LENGTH_LONG).show();

                                if (success.equals("1")) {

                                    Toast.makeText(Enquiry_listing.this, "Your Enquiry_listing has been submitted! We will get back to you over E-mail", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(Enquiry_listing.this, UserDashboard.class);
                                    startActivity(i);
                                    finish();

                                }

                            } catch (JSONException e) {

                                Toast.makeText(Enquiry_listing.this, e.toString(), Toast.LENGTH_LONG).show();
                                Log.d("error1 ", e.toString());

                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(Enquiry_listing.this, error.toString(), Toast.LENGTH_LONG).show();
                            Log.d("error2 ", error.toString());

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> params = new HashMap<>();
                            params.put("subject", sub);
                            params.put("message", msg);

                            shared = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                            String idKey = (shared.getString(userid, ""));

                            params.put("email", idKey);

                            return params;
                        }
                    };

                    mStringRequest.setShouldCache(false);
                    mRequestQueue.add(mStringRequest);

                }
            }
        });

    }

    private String getBaseUrl() {
        return "http://" + getResources().getString(R.string.machine_ip_address) +"/MiniPocket/sendEnquiry.php";
    }
}