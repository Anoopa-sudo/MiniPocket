package com.application.minipocket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends BaseAdapter {


        Context context;
        ArrayList<Movie> movies;
        String user;
        public MoviesAdapter(Context context, ArrayList<Movie> movies) {
            this.context = context;
            this.movies = movies;
        }



        @Override
        public int getCount() {
            return movies.size();
        }

        @Override
        public Object getItem(int i) {
            return movies.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.movie_item, null);

            ImageView moviePoster = view.findViewById(R.id.movie_poster);
            TextView movieTitle = view.findViewById(R.id.movie_title);
            TextView movieDate = view.findViewById(R.id.datet);

            Movie movie = movies.get(i);
            movieTitle.setText(movie.getTitle());
            movieDate.setText(movie.getRelease_date());
            Glide.with(context)
                    .load(movie.getPoster())
                    .placeholder(R.drawable.ic_baseline_movie_filter_24) // Placeholder image until the actual image is loaded
                    .error(R.drawable.ic_baseline_movie_filter_24) // Error image if the actual image fails to load
                    .into(moviePoster);


            return view;
        }
    }






