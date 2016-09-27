package com.example.rupeshchaudhary.androidtest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public class Result {
    @SerializedName("sections")
    private Sections mSections;
    private String edition;

    public Sections getSections(){
        return mSections;
    }
}
