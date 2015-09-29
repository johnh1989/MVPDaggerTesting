package com.agoodkissapp.mvpdaggertesting.Adapters;

/**
 * Created by doktor on 8/13/2015.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.agoodkissapp.mvpdaggertesting.Movie;

import java.util.ArrayList;

import com.agoodkissapp.mvpdaggertesting.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private ArrayList<Movie> movieList = new ArrayList<>();

    private Context context;


    public RecyclerAdapter(ArrayList<Movie> movieList, Context context) {
        this.movieList.addAll(movieList);
        this.context = context;
    }

    public interface ClickListener {
        void onClick(View v, int position);
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        final View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);


        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    public void addMovies(ArrayList<Movie> movies){
        Log.d("happening", "here");
        movieList.addAll(movies);
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setClickListener(new ClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(context, movieList.get(position).title, Toast.LENGTH_SHORT).show();
            }
        });


        holder.txtTitle.setText(movieList.get(position).title);

        //movieList.get(position).setCoverImg();

        holder.imgCover.setImageBitmap(movieList.get(position).imgCover);

    }


    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ClickListener mListener;

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getPosition());
        }

        TextView txtTitle;
        ImageView imgCover;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemLayoutView.setOnClickListener(this);


            txtTitle = (TextView) itemLayoutView.findViewById(R.id.txtTitle);
            imgCover = (ImageView) itemLayoutView.findViewById(R.id.imgCover);
        }

        public void setClickListener(ClickListener l) {
            mListener = l;
        }
    }

    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movieList.size();
    }
}