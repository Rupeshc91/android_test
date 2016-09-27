package com.example.rupeshchaudhary.androidtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rupeshchaudhary.androidtest.model.Section;

import java.util.ArrayList;

import retrofit2.http.PUT;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public class DetailsAdapter extends FragmentPagerAdapter {
    private ArrayList<Section> mSections;

    public DetailsAdapter(FragmentManager fragmentManager, ArrayList<Section> sections) {
        super(fragmentManager);
        mSections = sections;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailFragment.newInstance(mSections.get(position));
    }

    @Override
    public int getCount() {
        return mSections.size();
    }
}
