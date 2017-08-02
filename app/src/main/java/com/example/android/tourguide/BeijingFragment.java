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
public class BeijingFragment extends Fragment {

    protected final ArrayList<Tourism> mBJ = new ArrayList<>();

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
        rv.setAdapter(new SimpleStringRecyclerViewAdapter(rv.getContext(), mBJ));

        return rv;
    }

    private void initializeData() {
        mBJ.add(new Tourism(getString(R.string.beijing_1), getString(R.string.beijing_L1),
                R.drawable.beijing_1, getString(R.string.beijing_description_1)));
        mBJ.add(new Tourism(getString(R.string.beijing_2), getString(R.string.beijing_L2),
                R.drawable.beijing_2, getString(R.string.beijing_description_2)));
        mBJ.add(new Tourism(getString(R.string.beijing_3), getString(R.string.beijing_L3),
                R.drawable.beijing_3, getString(R.string.beijing_description_3)));
        mBJ.add(new Tourism(getString(R.string.beijing_4), getString(R.string.beijing_L4),
                R.drawable.beijing_4, getString(R.string.beijing_description_4)));
        mBJ.add(new Tourism(getString(R.string.beijing_5), getString(R.string.beijing_L5),
                R.drawable.beijing_5, getString(R.string.beijing_description_5)));
        mBJ.add(new Tourism(getString(R.string.beijing_6), getString(R.string.beijing_L6),
                R.drawable.beijing_6, getString(R.string.beijing_description_6)));
        mBJ.add(new Tourism(getString(R.string.beijing_7), getString(R.string.beijing_L7),
                R.drawable.beijing_7, getString(R.string.beijing_description_7)));
        mBJ.add(new Tourism(getString(R.string.beijing_8), getString(R.string.beijing_L8),
                R.drawable.beijing_8, getString(R.string.beijing_description_8), getString(R.string.beijing_date_1)));
        mBJ.add(new Tourism(getString(R.string.beijing_9), getString(R.string.beijing_L9),
                R.drawable.beijing_9, getString(R.string.beijing_description_9), getString(R.string.beijing_date_2)));
    }

}
