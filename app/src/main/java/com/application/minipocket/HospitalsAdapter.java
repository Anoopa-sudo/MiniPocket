package com.application.minipocket;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.util.ArrayList;

public class HospitalsAdapter extends BaseAdapter {

    Context context;
    ArrayList<Hospital> hospitals;
    String user;
    public HospitalsAdapter(Context context, ArrayList<Hospital> hospitals) {
        this.context = context;
        this.hospitals = hospitals;
    }



    @Override
    public int getCount() {
        return hospitals.size();
    }

    @Override
    public Object getItem(int i) {
        return hospitals.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.hospital_item, null);

        TextView namet = (TextView) view.findViewById(R.id.namet);
        TextView loct = (TextView) view.findViewById(R.id.loct);
        Button mapbt = (Button) view.findViewById(R.id.mapbt);
        TextView phonet = (TextView) view.findViewById(R.id.phonet);
        TextView bedt = (TextView) view.findViewById(R.id.bedt);
        TextView emgt = (TextView) view.findViewById(R.id.emgt);
        ImageView imgv = (ImageView) view.findViewById(R.id.imgv);

        Hospital hospital = hospitals.get(i);
        namet.setText(hospital.getName());
        loct.setText(hospital.getLocation());
        phonet.setText(hospital.getPhone_number());
        bedt.setText(hospital.getNumber_of_beds()+"");
        emgt.setText("Emergency: " + (hospital.isHas_emergency() ? "Available" : "Unavailable"));

        mapbt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Log.i("Maptest",hospital.getAddress());
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + hospital.getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });

        Glide.with(this.context)
                .load(hospital.getImage())
                .placeholder(R.drawable.ic_baseline_local_hospital_24) // Placeholder image until the actual image is loaded
                .error(R.drawable.ic_baseline_local_hospital_24) // Error image if the actual image fails to load
                .into(imgv);

        return view;
    }
}

