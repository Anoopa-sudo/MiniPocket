package com.application.minipocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Supermarkets_listing extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static SharedPreferences shared;
    ArrayList<Supermarket> supermarkets = new ArrayList<>();
    SupermarketsAdapter sbha;
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;
    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarkets_listing);
        getSupportActionBar().hide();
        Button backBt = (Button) findViewById(R.id.backBt);

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Supermarkets_listing.this, UserDashboard.class);
                startActivity(i);
                finish();

            }
        });

        list = findViewById(R.id.smList);
        mRequestQueue = Volley.newRequestQueue(Supermarkets_listing.this);
        mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("tagconvertstrSupermarkets", "["+response+"]");
                try {

                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i<array.length(); i++){

                        JSONObject object = array.getJSONObject(i);

                        String id = object.getString("id");
                        String name = object.getString("name");
                        String location = object.getString("location");
                        String address = object.getString("address");
                        String phone_number = object.getString("phone_number");
                        String otime = object.getString("open_time");
                        String ctime = object.getString("close_time");
                        String offers = object.getString("offers");
                        String image = object.getString("image");

                        Supermarket supermarket = new Supermarket(Integer.parseInt(id), name, location, address, phone_number,otime,ctime,offers,image);
                        supermarkets.add(supermarket);
                    }


                    try {
                        loadListView(supermarkets);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }




                } catch (JSONException e) {

                    Toast.makeText(Supermarkets_listing.this,e.toString(),Toast.LENGTH_LONG).show();
                    Log.d("error1 ", e.toString());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Supermarkets_listing.this,error.toString(),Toast.LENGTH_LONG).show();
                Log.d("error2 ", error.toString());

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                shared = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
                String idKey = (shared.getString(userid, ""));

                params.put("id",idKey);

                return params;
            }
        };

        mStringRequest.setShouldCache(false);
        mRequestQueue.add(mStringRequest);


    }
    private String getBaseUrl (){
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/MiniPocket/getSupermarkets.php";
    }

    private void loadListView(ArrayList<Supermarket> supermarkets) throws ParseException {
        sbha = new SupermarketsAdapter(Supermarkets_listing.this,supermarkets);
        list.setAdapter(sbha);

    }
}