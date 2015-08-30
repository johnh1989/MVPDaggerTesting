package com.agoodkissapp.mvpdaggertesting.Api;

import com.agoodkissapp.mvpdaggertesting.Movie;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by doktor on 8/30/2015.
 */
public interface ResumeApi {

    @GET("/movies.json")
    void getMovieList( Callback<ArrayList<Movie>> callback );


//    @POST("/books")
//    void addBook(@Body Book book, Callback<Book> addedBook );
//
//    @DELETE("/clean")
//    void deleteAllBooks(Callback<Response> responseCallback);
//
//    @PUT("/books/{id}")
//    void updateBook(@Body Book book, @Path("id") String id, Callback<Book> updatedBook);
//
//    @DELETE("/books/{id}")
//    void deleteBook(@Path("id") String id, Callback<Response> responseCallback);
}