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

public class Hospitals_listing extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static SharedPreferences shared;
    ArrayList<Hospital> hospitals = new ArrayList<>();
    HospitalsAdapter sbha;
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;
    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals_listing);
        getSupportActionBar().hide();
        Button backBt = (Button) findViewById(R.id.backBt);

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Hospitals_listing.this, UserDashboard.class);
                startActivity(i);
                finish();

            }
        });

        list = findViewById(R.id.hospitalsList);
        mRequestQueue = Volley.newRequestQueue(Hospitals_listing.this);
        mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("tagconvertstrHospitals", "["+response+"]");
                try {

                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i<array.length(); i++){

                        JSONObject object = array.getJSONObject(i);

                        String id = object.getString("id");
                        String name = object.getString("name");
                        String location = object.getString("location");
                        String address = object.getString("address");
                        String phone_number = object.getString("phone_number");
                        String number_of_beds = object.getString("number_of_beds");
                        int has_emergency_int = object.getInt("has_emergency");
                        boolean has_emergency = has_emergency_int == 1;
                        String image = object.getString("image");

                        Hospital hospital = new Hospital(Integer.parseInt(id), name, location, address, phone_number,Integer.parseInt(number_of_beds),has_emergency,image);
                        hospitals.add(hospital);
                    }


                    try {
                        loadListView(hospitals);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }




                } catch (JSONException e) {

                    Toast.makeText(Hospitals_listing.this,e.toString(),Toast.LENGTH_LONG).show();
                    Log.d("error1 ", e.toString());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Hospitals_listing.this,error.toString(),Toast.LENGTH_LONG).show();
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
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/MiniPocket/getHospitals.php";
    }

    private void loadListView(ArrayList<Hospital> hospitals) throws ParseException {
        sbha = new HospitalsAdapter(Hospitals_listing.this,hospitals);
        list.setAdapter(sbha);

    }
}