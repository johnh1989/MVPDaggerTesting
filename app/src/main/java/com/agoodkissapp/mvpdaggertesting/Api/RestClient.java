package com.agoodkissapp.mvpdaggertesting.Api;

import android.util.Log;


import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by doktor on 8/30/2015.
 */
public class RestClient {

    private static ResumeApi REST_CLIENT;
    private static String URL_ROOT = "http://iridiumlabs.org";

    static {
        setupRestClient();
    }


    private RestClient() {}

    /**
     *
     * @return instance of the @Link ResumeApi
     */
    public static ResumeApi get() {
        return REST_CLIENT;
    }

    /**
     * static method to set up the http client and adapter
     */
    private static void setupRestClient() {

        File httpCacheDirectory = new File(System.getProperty("java.io.tmpdir"), UUID.randomUUID().toString());

        Cache cache = null;
        try {
            cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        } catch (Exception e) {
            Log.e("OKHttp", "Could not create http cache", e);
        }

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        if (cache != null) {
            okHttpClient.setCache(cache);
        }

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(URL_ROOT)
                .setClient(new OkClient(okHttpClient))
                .setLogLevel(RestAdapter.LogLevel.HEADERS);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(ResumeApi.class);
    }
}