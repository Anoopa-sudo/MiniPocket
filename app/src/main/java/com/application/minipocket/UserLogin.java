package com.application.minipocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class UserLogin extends AppCompatActivity {
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        getSupportActionBar().hide();

        Button LoginBt = (Button) findViewById(R.id.LoginBt);
        TextView signBt = (TextView) findViewById(R.id.signuplink);

        final EditText loginId = (EditText) findViewById(R.id.LoginIdt);
        final EditText passt = (EditText) findViewById(R.id.LoginPasst);

        LoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginId.getText().toString();
                String pass = passt.getText().toString();

                if(email.equals("")||pass.equals("")){
                    Toast.makeText(UserLogin.this,"Please fill all fields to continue", Toast.LENGTH_SHORT).show();
                }
                else{
                    mRequestQueue = Volley.newRequestQueue(UserLogin.this);
                    mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("tagconvertstrUser", "["+response+"]");
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("success");
                                String message = jsonObject.getString("message");


                                Toast.makeText(UserLogin.this,message,Toast.LENGTH_LONG).show();

                                if (success.equals("1")) {

                                    SharedPreferences.Editor editor = MainActivity.shared.edit();
                                    editor.putString(MainActivity.userid, email);
                                    editor.putString(MainActivity.role, "User");
                                    editor.commit();

                                    Intent i=new Intent(UserLogin.this, UserDashboard.class);
                                    i.putExtra("user",email);
                                    startActivity(i);
                                    finish();

                                }

                            } catch (JSONException e) {

                                Toast.makeText(UserLogin.this,e.toString(),Toast.LENGTH_LONG).show();
                                Log.d("error1 ", e.toString());

                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(UserLogin.this,error.toString(),Toast.LENGTH_LONG).show();
                            Log.d("error2 ", error.toString());

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            Map<String, String> params = new HashMap<>();

                            params.put("email",email);
                            params.put("password",pass);

                            return params;
                        }
                    };

                    mStringRequest.setShouldCache(false);
                    mRequestQueue.add(mStringRequest);

                }
            }
        });

        signBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UserLogin.this, UserSignUp.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(UserLogin.this, Home.class);
        startActivity(i);
        finish();
    }
    private String getBaseUrl (){
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/MiniPocket/user_login.php";
    }
}