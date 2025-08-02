package com.application.minipocket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

public class Directory_listing extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static SharedPreferences shared;
    ArrayList<Directory> directories = new ArrayList<>();
    DirectoryAdapter sbha;
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;
    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory_lisitng);
        getSupportActionBar().hide();
        Button backBt = (Button) findViewById(R.id.backBt);
        Button searchBt = (Button) findViewById(R.id.searchBt);
        TextView searcht = (TextView) findViewById(R.id.searcht);
        TextView resultt = (TextView) findViewById(R.id.resultt);
        TextView searchKeyt = (TextView) findViewById(R.id.searchKeyt);

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Directory_listing.this, UserDashboard.class);
                startActivity(i);
                finish();

            }
        });


        list = findViewById(R.id.directoryList);
        searchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String srchKey = searcht.getText().toString();
                searchKeyt.setText("Searching for: "+srchKey);
                mRequestQueue = Volley.newRequestQueue(Directory_listing.this);
                mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("tagconvertstrDirectories", "["+response+"]");
                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);

                                String id = object.getString("id");
                                String name = object.getString("name");
                                String service_type = object.getString("service_type");
                                String location = object.getString("location");
                                String address = object.getString("address");
                                String phone_number = object.getString("phone_number");


                                Directory directory = new Directory(Integer.parseInt(id), name, service_type, location, address, phone_number);
                                directories.add(directory);
                                resultt.setText(array.length()+" Results Found");
                            }


                            try {
                                loadListView(directories);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }




                        } catch (JSONException e) {

//                            Toast.makeText(Directory_listing.this,e.toString(),Toast.LENGTH_LONG).show();
                            Log.d("error1 ", e.toString());
                            resultt.setText(0+" Results Found");

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Directory_listing.this,error.toString(),Toast.LENGTH_LONG).show();
                        Log.d("error2 ", error.toString());
                        resultt.setText(0+" Results Found");

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();
                        params.put("search",srchKey);

                        return params;
                    }
                };

                mStringRequest.setShouldCache(false);
                mRequestQueue.add(mStringRequest);
            }
        });

    }
    private String getBaseUrl (){
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/MiniPocket/getDirectories.php";
    }

    private void loadListView(ArrayList<Directory> directories) throws ParseException {
        sbha = new DirectoryAdapter(Directory_listing.this,directories);
        list.setAdapter(sbha);
    }
}