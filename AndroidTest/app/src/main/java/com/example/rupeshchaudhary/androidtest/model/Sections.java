package com.example.rupeshchaudhary.androidtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public class Sections {
    @SerializedName("National")
    private ArrayList<Section> mNationalSection;
    @SerializedName("City News")
    private ArrayList<Section> mCityNewsSection;

    public ArrayList<Section> getNationalSection() {
        return mNationalSection;
    }

    public ArrayList<Section> getCityNewsSection() {
        return mCityNewsSection;
    }

}
