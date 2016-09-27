package com.example.rupeshchaudhary.androidtest.Network;

import com.example.rupeshchaudhary.androidtest.model.Section;
import com.example.rupeshchaudhary.androidtest.model.SectionsResponse;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public interface ApiService {
    @GET("news.json")
    Call<SectionsResponse>getNewsFeeds();
}
