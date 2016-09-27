package com.example.rupeshchaudhary.androidtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rupeshchaudhary.androidtest.model.Section;

import org.w3c.dom.Text;


public class DetailFragment extends Fragment {
    private static final String ARG_SECTION = "section";
    private ImageView mImageArticle;
    private TextView mTitleText;
    private TextView mDescriptionText;
    private WebView mWebView;


    public DetailFragment() {
        // Required empty public constructor
    }


    public static DetailFragment newInstance(Section section) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SECTION, section);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        mImageArticle = (ImageView) view.findViewById(R.id.image_article);
        mDescriptionText = (TextView) view.findViewById(R.id.text_description);
        mTitleText = (TextView) view.findViewById(R.id.text_title);
        mWebView = (WebView) view.findViewById(R.id.web_view);
        setView();
    }

    private void setView() {
        if (getArguments() != null) {
            Section section = (Section) getArguments().get(ARG_SECTION);
            Glide.with(getActivity()).load(section.getImage()).placeholder(R.drawable.placeholder).into(mImageArticle);
            mTitleText.setText(section.getTitle());
            mDescriptionText.setText(section.getSummary());
            mWebView.loadUrl(section.getUrl());
        }
    }
}
