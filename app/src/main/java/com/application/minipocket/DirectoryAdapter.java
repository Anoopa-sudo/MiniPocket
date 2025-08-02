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

public class DirectoryAdapter extends BaseAdapter {


    Context context;
    ArrayList<Directory> directories;
    String user;
    public DirectoryAdapter(Context context, ArrayList<Directory> directories) {
        this.context = context;
        this.directories = directories;
    }



    @Override
    public int getCount() {
        return directories.size();
    }

    @Override
    public Object getItem(int i) {
        return directories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.directory_item, null);

        TextView namet = (TextView) view.findViewById(R.id.namet);
        TextView loct = (TextView) view.findViewById(R.id.loct);
        Button mapbt = (Button) view.findViewById(R.id.mapbt);
        TextView phonet = (TextView) view.findViewById(R.id.phonet);

        Directory directory = directories.get(i);
        namet.setText(directory.getName());
        loct.setText(directory.getLocation());
        phonet.setText(directory.getPhoneNumber());

        mapbt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Log.i("Maptest",directory.getAddress());
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + directory.getAddress());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });

        return view;
    }
}

