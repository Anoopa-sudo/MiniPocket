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

public class Cinemas_listing extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static SharedPreferences shared;
    ArrayList<Cinema> cinemas = new ArrayList<>();
    CinemasAdapter sbha;
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;
    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemas_listing);
        getSupportActionBar().hide();
        Button backBt = (Button) findViewById(R.id.backBt);
        Button moviesBt = (Button) findViewById(R.id.moviesBt);

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Cinemas_listing.this, UserDashboard.class);
                startActivity(i);
                finish();

            }
        });
        moviesBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Cinemas_listing.this, Movies_listing.class);
                startActivity(i);
                finish();

            }
        });




        list = findViewById(R.id.cinemasList);
        mRequestQueue = Volley.newRequestQueue(Cinemas_listing.this);
        mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("tagconvertstrCinemas", "["+response+"]");
                try {

                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i<array.length(); i++){

                        JSONObject object = array.getJSONObject(i);

                        String id = object.getString("id");
                        String name = object.getString("name");
                        String location = object.getString("location");
                        String address = object.getString("address");
                        String phone_number = object.getString("phone_number");
                        String number_of_beds = object.getString("number_of_screens");
                        int has_emergency_int = object.getInt("has_parking");
                        boolean has_emergency = has_emergency_int == 1;
                        String image = object.getString("image");

                        Cinema hospital = new Cinema(Integer.parseInt(id), name, location, address, phone_number,Integer.parseInt(number_of_beds),has_emergency,image);
                        cinemas.add(hospital);
                    }


                    try {
                        loadListView(cinemas);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }




                } catch (JSONException e) {

                    Toast.makeText(Cinemas_listing.this,e.toString(),Toast.LENGTH_LONG).show();
                    Log.d("error1 ", e.toString());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Cinemas_listing.this,error.toString(),Toast.LENGTH_LONG).show();
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
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/MiniPocket/getCinemas.php";
    }

    private void loadListView(ArrayList<Cinema> cinemas) throws ParseException {
        sbha = new CinemasAdapter(Cinemas_listing.this,cinemas);
        list.setAdapter(sbha);

    }
}