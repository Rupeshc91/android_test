package com.example.rupeshchaudhary.androidtest.Network;

import android.support.v7.app.AppCompatActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public class RestClient {
    public static final String BASE_URL="https://s3.amazonaws.com/media.mobstac.com/test/";
    public RestClient(){

    }
    public ApiService createRestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        return service;
    }
}
