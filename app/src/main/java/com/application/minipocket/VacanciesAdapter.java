package com.application.minipocket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VacanciesAdapter extends BaseAdapter {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String userid = "userKey";
    public static SharedPreferences shared;
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;

    Context context;
    ArrayList<Vacancy> vacancies;
    String user;
    public VacanciesAdapter(Context context, ArrayList<Vacancy> vacancies) {
        this.context = context;
        this.vacancies = vacancies;
    }



    @Override
    public int getCount() {
        return vacancies.size();
    }

    @Override
    public Object getItem(int i) {
        return vacancies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.vacancy_item, null);

        TextView postt = (TextView) view.findViewById(R.id.postt);
        TextView companyt = (TextView) view.findViewById(R.id.companyt);
        TextView loct = (TextView) view.findViewById(R.id.loct);
        TextView emailt = (TextView) view.findViewById(R.id.emailt);
        Button applybt = (Button) view.findViewById(R.id.applybt);
        TextView desct = (TextView) view.findViewById(R.id.desct);
        TextView salaryt = (TextView) view.findViewById(R.id.salaryt);

        Vacancy vacancy = vacancies.get(i);
        postt.setText(vacancy.getJobPost());
        companyt.setText(vacancy.getCompanyName());
        loct.setText(vacancy.getLocation());
        emailt.setText(vacancy.getEmail());
        desct.setText(vacancy.getDescription());
        salaryt.setText(vacancy.getSalary());

        applybt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                mRequestQueue = Volley.newRequestQueue(context);
                // Progress

                mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("tagconvertstrUser", "[" + response + "]");
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            String message = jsonObject.getString("message");


                            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

                            if (success.equals("1")) {

                                Toast.makeText(context, "Job Application has been submitted !! We'll get back to you via E-mail", Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {

                            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
                            Log.d("error1 ", e.toString());

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                        Log.d("error2 ", error.toString());

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();

                        shared = context.getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);
                        String idKey = (shared.getString(userid, ""));
                        params.put("email", idKey);
                        params.put("vacancy_id", Integer.toString(vacancy.getId()));

                        return params;
                    }
                };

                mStringRequest.setShouldCache(false);
                mRequestQueue.add(mStringRequest);
            }
        });

        return view;
    }
    private String getBaseUrl() {
        return "http://" + context.getResources().getString(R.string.machine_ip_address) +"/MiniPocket/apply_job.php";
    }
}

