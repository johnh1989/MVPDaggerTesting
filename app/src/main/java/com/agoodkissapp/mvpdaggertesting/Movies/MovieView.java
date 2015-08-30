package com.agoodkissapp.mvpdaggertesting.Movies;

import com.agoodkissapp.mvpdaggertesting.Movie;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.ArrayList;

/**
 * Created by doktor on 8/30/2015.
 */
public interface MovieView extends MvpView {

    void showLoading();
    void hideLoading();
    void setData(ArrayList<Movie> movies);

}
