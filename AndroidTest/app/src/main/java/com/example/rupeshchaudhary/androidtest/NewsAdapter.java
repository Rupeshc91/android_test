package com.example.rupeshchaudhary.androidtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rupeshchaudhary.androidtest.model.Section;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by rupeshchaudhary on 08/09/2016.
 */
public class NewsAdapter extends FragmentPagerAdapter {
    private LinkedHashMap<String, ArrayList<Section>> mSectionsMap;

    public NewsAdapter(FragmentManager fragmentManager, LinkedHashMap<String, ArrayList<Section>> sectionMap) {
        super(fragmentManager);
        mSectionsMap = sectionMap;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewsFragment.newInstance(mSectionsMap.get("National"));
            case 1:
                return NewsFragment.newInstance(mSectionsMap.get("City News"));
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "National";
            case 1:
                return "City News";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return mSectionsMap.size();
    }
}
