package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SimpleStringRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private ArrayList<Tourism> mValues;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String mBoundString;
        public int mID;
        public Tourism mItem;

        public final View mView;
        public final ImageView mImageView;
        public final TextView mTextView1;
        public final TextView mTextView2;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.avatar);
            mTextView1 = (TextView) view.findViewById(R.id.title);
            mTextView2 = (TextView) view.findViewById(R.id.subTitle);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView1.getText();
        }
    }

    public SimpleStringRecyclerViewAdapter(Context context, ArrayList<Tourism> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mBoundString = mValues.get(position).getTourismName();
        holder.mID = mValues.get(position).getResourceId();
        holder.mTextView1.setText(mValues.get(position).getTourismName());
        holder.mTextView2.setText(mValues.get(position).getLocation());
        holder.mItem = mValues.get(position);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, tourismDetailActivity.class);
                intent.putExtra(tourismDetailActivity.EXTRA_NAME, holder.mItem);

                context.startActivity(intent);
            }
        });

        Glide.with(holder.mImageView.getContext())
                .load(holder.mID)
                .fitCenter()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
