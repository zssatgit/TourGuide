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
public class XianFragment extends Fragment {

    protected final ArrayList<Tourism> mXA = new ArrayList<>();

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
        rv.setAdapter(new SimpleStringRecyclerViewAdapter(rv.getContext(), mXA));

        return rv;
    }

    private void initializeData() {
        mXA.add(new Tourism(getString(R.string.xian_1), getString(R.string.xian_L1),
                R.drawable.xian_1, getString(R.string.xian_description_1)));
        mXA.add(new Tourism(getString(R.string.xian_2), getString(R.string.xian_L2),
                R.drawable.xian_2, getString(R.string.xian_description_2)));
        mXA.add(new Tourism(getString(R.string.xian_3), getString(R.string.xian_L3),
                R.drawable.xian_3, getString(R.string.xian_description_3)));
        mXA.add(new Tourism(getString(R.string.xian_4), getString(R.string.xian_L4),
                R.drawable.xian_4, getString(R.string.xian_description_4)));
        mXA.add(new Tourism(getString(R.string.xian_5), getString(R.string.xian_L5),
                R.drawable.xian_5, getString(R.string.xian_description_5)));
        mXA.add(new Tourism(getString(R.string.xian_6), getString(R.string.xian_L6),
                R.drawable.xian_6, getString(R.string.xian_description_6), getString(R.string.xian_date_1)));
    }

}
