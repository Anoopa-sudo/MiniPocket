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

public class SupermarketsAdapter extends BaseAdapter {

    Context context;
    ArrayList<Supermarket> supermarkets;
    String user;
    public SupermarketsAdapter(Context context, ArrayList<Supermarket> supermarkets) {
        this.context = context;
        this.supermarkets = supermarkets;
    }



    @Override
    public int getCount() {
        return supermarkets.size();
    }

    @Override
    public Object getItem(int i) {
        return supermarkets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.supermarket_item, null);

        TextView namet = (TextView) view.findViewById(R.id.namet);
        TextView loct = (TextView) view.findViewById(R.id.loct);
        Button mapbt = (Button) view.findViewById(R.id.mapbt);
        TextView phonet = (TextView) view.findViewById(R.id.phonet);
        TextView otimet = (TextView) view.findViewById(R.id.otimet);
        TextView ctimet = (TextView) view.findViewById(R.id.ctimet);
        TextView offerst = (TextView) view.findViewById(R.id.offerst);
        ImageView imgv = (ImageView) view.findViewById(R.id.imgv);

        Supermarket supermarket = supermarkets.get(i);
        namet.setText(supermarket.getName());
        loct.setText(supermarket.getLocation());
        phonet.setText(supermarket.getPhoneNumber());
        otimet.setText(supermarket.getOpenTime()+"");
        ctimet.setText(supermarket.getCloseTime()+"");
        offerst.setText(supermarket.getOffers());

        mapbt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Log.i("Maptest",supermarket.getAddress());
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + supermarket.getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });

        Glide.with(this.context)
                .load(supermarket.getImage())
                .placeholder(R.drawable.ic_baseline_storefront_24) // Placeholder image until the actual image is loaded
                .error(R.drawable.ic_baseline_storefront_24) // Error image if the actual image fails to load
                .into(imgv);

        return view;
    }
}

