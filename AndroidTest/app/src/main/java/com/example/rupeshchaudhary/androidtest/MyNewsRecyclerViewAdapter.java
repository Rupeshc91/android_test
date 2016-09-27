package com.example.rupeshchaudhary.androidtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rupeshchaudhary.androidtest.model.Section;
import com.example.rupeshchaudhary.androidtest.utility.Constant;

import java.util.ArrayList;
import java.util.List;


public class MyNewsRecyclerViewAdapter extends RecyclerView.Adapter<MyNewsRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Section> mSectionsList;
    private final NewsFragment.OnListFragmentInteractionListener mListener;

    public MyNewsRecyclerViewAdapter(ArrayList<Section> sectionList, NewsFragment.OnListFragmentInteractionListener listener) {
        mSectionsList = sectionList;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextViewTitle.setText(mSectionsList.get(position).getTitle());
        holder.mTextViewDate.setText(mSectionsList.get(position).getTime());
        Glide.with(holder.itemView.getContext()).load(mSectionsList.get(position).getImage()).placeholder(R.drawable.placeholder).into(holder.mImageArticle);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDetailActivity(holder.itemView.getContext(), position);
            }
        });
    }

    private void callDetailActivity(Context context, int position) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constant.SECTION_LIST, mSectionsList);
        intent.putExtra(Constant.POSITION, position);
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return mSectionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTextViewTitle;
        public final TextView mTextViewDate;
        public final ImageView mImageArticle;

        public ViewHolder(View view) {
            super(view);
            mTextViewTitle = (TextView) view.findViewById(R.id.text_title);
            mTextViewDate = (TextView) view.findViewById(R.id.text_date);
            mImageArticle = (ImageView) view.findViewById(R.id.image_article);
        }


    }
}
