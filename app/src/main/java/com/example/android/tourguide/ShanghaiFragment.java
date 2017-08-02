package com.example.android.tourguide;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShanghaiFragment extends Fragment {

    protected final ArrayList<Tourism> mSH = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.content_main, container, false);

        initializeData();

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(new SimpleStringRecyclerViewAdapter(rv.getContext(), mSH));

        return rv;
    }

    private void initializeData() {
        mSH.add(new Tourism(getString(R.string.shanghai_1), getString(R.string.shanghai_L1),
                R.drawable.shanghai_1, getString(R.string.shanghai_description_1)));
        mSH.add(new Tourism(getString(R.string.shanghai_2), getString(R.string.shanghai_L2),
                R.drawable.shanghai_2, getString(R.string.shanghai_description_2)));
        mSH.add(new Tourism(getString(R.string.shanghai_3), getString(R.string.shanghai_L3),
                R.drawable.shanghai_3, getString(R.string.shanghai_description_3)));
        mSH.add(new Tourism(getString(R.string.shanghai_4), getString(R.string.shanghai_L4),
                R.drawable.shanghai_4, getString(R.string.shanghai_description_4)));
        mSH.add(new Tourism(getString(R.string.shanghai_5), getString(R.string.shanghai_L5),
                R.drawable.shanghai_5, getString(R.string.shanghai_description_5)));
        mSH.add(new Tourism(getString(R.string.shanghai_6), getString(R.string.shanghai_L6),
                R.drawable.shanghai_6, getString(R.string.shanghai_description_6), getString(R.string.shanghai_date_1)));
    }

}
