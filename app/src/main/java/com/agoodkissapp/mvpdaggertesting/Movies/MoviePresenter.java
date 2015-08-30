package com.agoodkissapp.mvpdaggertesting.Movies;

import android.util.Log;

import com.agoodkissapp.mvpdaggertesting.Api.RestClient;
import com.agoodkissapp.mvpdaggertesting.Movie;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by doktor on 8/30/2015.
 */
public class MoviePresenter extends MvpBasePresenter<MovieView> {

    public static final String TAG = "MoviePresenter";

    public void getMovieList() {
        Log.d(TAG, "getMovieList()");
        RestClient.get().getMovieList(new Callback<ArrayList<Movie>>() {
            @Override
            public void success(ArrayList<Movie> movies, Response response) {

                Log.d("calling ", "setData");
                getView().setData(movies);
                getView().hideLoading();

            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "failure");
                Log.d(TAG, error.getMessage());
                getView().hideLoading();

            }
        });
    }

}
