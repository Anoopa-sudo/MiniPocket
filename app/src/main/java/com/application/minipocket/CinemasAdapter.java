package com.application.minipocket;


import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;

public class CinemasAdapter extends BaseAdapter {

    Context context;
    ArrayList<Cinema> cinemas;
    String user;
    public CinemasAdapter(Context context, ArrayList<Cinema> cinemas) {
        this.context = context;
        this.cinemas = cinemas;
    }



    @Override
    public int getCount() {
        return cinemas.size();
    }

    @Override
    public Object getItem(int i) {
        return cinemas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.cinema_item, null);

        TextView namet = (TextView) view.findViewById(R.id.namet);
        TextView loct = (TextView) view.findViewById(R.id.loct);
        Button mapbt = (Button) view.findViewById(R.id.mapbt);
        TextView phonet = (TextView) view.findViewById(R.id.phonet);
        TextView screent = (TextView) view.findViewById(R.id.screent);
        TextView parkt = (TextView) view.findViewById(R.id.parkt);
        ImageView imgv = (ImageView) view.findViewById(R.id.imgv);

        Cinema cinema = cinemas.get(i);
        namet.setText(cinema.getName());
        loct.setText(cinema.getLocation());
        phonet.setText(cinema.getPhoneNumber());
        screent.setText(cinema.getNumberOfScreens()+"");
        parkt.setText("Parking: " + (cinema.isHasParking() ? "Available" : "Unavailable"));

        mapbt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Log.i("Maptest",cinema.getAddress());
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + cinema.getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });

        Glide.with(this.context)
                .load(cinema.getImage())
                .placeholder(R.drawable.ic_baseline_movie_filter_24) // Placeholder image until the actual image is loaded
                .error(R.drawable.ic_baseline_movie_filter_24) // Error image if the actual image fails to load
                .into(imgv);


        return view;
    }
}

