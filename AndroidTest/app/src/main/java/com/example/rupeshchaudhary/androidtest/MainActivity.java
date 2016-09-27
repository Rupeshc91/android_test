package com.example.rupeshchaudhary.androidtest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.rupeshchaudhary.androidtest.Network.RestClient;
import com.example.rupeshchaudhary.androidtest.model.Result;
import com.example.rupeshchaudhary.androidtest.model.Section;
import com.example.rupeshchaudhary.androidtest.model.SectionsResponse;
import com.example.rupeshchaudhary.androidtest.utility.NetWorkUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NewsFragment.OnListFragmentInteractionListener {

    private ViewPager mViewPager;
    private LinkedHashMap<String, ArrayList<Section>> mSectionsMap;
    private TabLayout mTablayout;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        if (NetWorkUtils.checkIsNetworkAvailable(getApplicationContext())) {
            callNewsFeedsApi();
        }
    }

    private void init() {
        mTablayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    private void callNewsFeedsApi() {
        RestClient restClient = new RestClient();
        mProgressBar.setVisibility(View.VISIBLE);
        Call<SectionsResponse> sections = restClient.createRestClient().getNewsFeeds();
        sections.enqueue(new Callback<SectionsResponse>() {
            @Override
            public void onResponse(Call<SectionsResponse> call, Response<SectionsResponse> response) {
                mProgressBar.setVisibility(View.GONE);
                SectionsResponse sectionsResponse = response.body();
                createSection(sectionsResponse);

            }

            @Override
            public void onFailure(Call<SectionsResponse> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);

            }
        });

    }

    private void createSection(SectionsResponse sectionsResponse) {
        Result result = sectionsResponse.getResult();
        mSectionsMap = new LinkedHashMap<>();
        mSectionsMap.put("National", result.getSections().getNationalSection());
        mSectionsMap.put("City News", result.getSections().getCityNewsSection());
        setAdapter();
    }

    private void setAdapter() {
        NewsAdapter newsAdapter = new NewsAdapter(getSupportFragmentManager(), mSectionsMap);
        mViewPager.setAdapter(newsAdapter);
        mTablayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onListFragmentInteraction() {

    }
}
