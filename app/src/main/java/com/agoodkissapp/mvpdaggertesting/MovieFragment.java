package com.agoodkissapp.mvpdaggertesting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.agoodkissapp.mvpdaggertesting.Adapters.RecyclerAdapter;
import com.agoodkissapp.mvpdaggertesting.Movies.MoviePresenter;
import com.agoodkissapp.mvpdaggertesting.Movies.MovieView;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieFragment extends MvpFragment<MovieView, MoviePresenter>
        implements MovieView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Bind(R.id.contentView) SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.loadingView) ProgressBar mProgressBar;

    @Bind(R.id.errorView) TextView mErrorText;

    RecyclerAdapter mAdapter = null;

    ArrayList<Movie> mMovieList = new ArrayList<>();


    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        return fragment;
    }

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public MoviePresenter createPresenter() {
        return new MoviePresenter();
    }


    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        presenter.getMovieList();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        Log.d("view created", "in fragment");

        // Setup contentView == SwipeRefreshView
        mSwipeRefreshLayout.setOnRefreshListener(this);

        // Setup recycler view
        mAdapter = new RecyclerAdapter(mMovieList, getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        presenter.getMovieList();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setData(ArrayList<Movie> movies) {
        mAdapter.addMovies(movies);
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
