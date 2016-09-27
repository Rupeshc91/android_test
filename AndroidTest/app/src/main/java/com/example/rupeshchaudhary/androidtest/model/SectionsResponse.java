package com.example.rupeshchaudhary.androidtest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public class SectionsResponse {
    @SerializedName("Result")
    private Result mResult;
    public Result getResult(){
        return mResult;
    }
}
