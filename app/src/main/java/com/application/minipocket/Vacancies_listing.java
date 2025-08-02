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

public class Vacancies_listing extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static SharedPreferences shared;
    ArrayList<Vacancy> vacancies = new ArrayList<>();
    VacanciesAdapter sbha;
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;
    private ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancies_listing);
        getSupportActionBar().hide();
        Button backBt = (Button) findViewById(R.id.backBt);
        Button searchBt = (Button) findViewById(R.id.searchBt);
        TextView searcht = (TextView) findViewById(R.id.searcht);
        TextView resultt = (TextView) findViewById(R.id.resultt);
        TextView searchKeyt = (TextView) findViewById(R.id.searchKeyt);

        backBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Vacancies_listing.this, UserDashboard.class);
                startActivity(i);
                finish();

            }
        });


        list = findViewById(R.id.vacList);
        searchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String srchKey = searcht.getText().toString();
                searchKeyt.setText("Searching for: "+srchKey);
                mRequestQueue = Volley.newRequestQueue(Vacancies_listing.this);
                mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("tagconvertstrDirectories", "["+response+"]");
                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);

                                String id = object.getString("id");
                                String job_post = object.getString("job_post");
                                String company_name = object.getString("company_name");
                                String location = object.getString("location");
                                String salary = object.getString("salary");
                                String description = object.getString("description");
                                String company_email = object.getString("company_email");


                                Vacancy vacancy = new Vacancy(Integer.parseInt(id), job_post, company_name, location, salary, description, company_email);
                                vacancies.add(vacancy);
                                resultt.setText(array.length()+" Results Found");
                            }


                            try {
                                loadListView(vacancies);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }




                        } catch (JSONException e) {

//                            Toast.makeText(Vacancies_listing.this,e.toString(),Toast.LENGTH_LONG).show();
                            Log.d("error1 ", e.toString());
                            resultt.setText(0+" Results Found");

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Vacancies_listing.this,error.toString(),Toast.LENGTH_LONG).show();
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
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/MiniPocket/getvacancies.php";
    }

    private void loadListView(ArrayList<Vacancy> vacancies) throws ParseException {
        sbha = new VacanciesAdapter(Vacancies_listing.this,vacancies);
        list.setAdapter(sbha);
    }
}