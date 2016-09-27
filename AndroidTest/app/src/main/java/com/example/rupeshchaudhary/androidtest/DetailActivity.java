package com.example.rupeshchaudhary.androidtest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rupeshchaudhary.androidtest.model.Section;
import com.example.rupeshchaudhary.androidtest.utility.Constant;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setAdapter();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.container);
    }

    private void setAdapter() {
        if (getIntent() != null) {
            ArrayList<Section> sections = (ArrayList<Section>) getIntent().getExtras().get(Constant.SECTION_LIST);
            int position = getIntent().getIntExtra(Constant.POSITION, 0);
            DetailsAdapter detailsAdapter = new DetailsAdapter(getSupportFragmentManager(), sections);
            mViewPager.setAdapter(detailsAdapter);
            mViewPager.setCurrentItem(position);
        }
    }


}
