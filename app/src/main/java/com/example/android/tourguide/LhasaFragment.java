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
public class LhasaFragment extends Fragment {

    protected final ArrayList<Tourism> mLS = new ArrayList<>();

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
        rv.setAdapter(new SimpleStringRecyclerViewAdapter(rv.getContext(), mLS));

        return rv;
    }

    private void initializeData() {
        mLS.add(new Tourism(getString(R.string.lhasa_1), getString(R.string.lhasa_L1),
                R.drawable.lhasa_1, getString(R.string.lhasa_description_1)));
        mLS.add(new Tourism(getString(R.string.lhasa_2), getString(R.string.lhasa_L2),
                R.drawable.lhasa_2, getString(R.string.lhasa_description_2)));
        mLS.add(new Tourism(getString(R.string.lhasa_3), getString(R.string.lhasa_L3),
                R.drawable.lhasa_3, getString(R.string.lhasa_description_3)));
        mLS.add(new Tourism(getString(R.string.lhasa_4), getString(R.string.lhasa_L4),
                R.drawable.lhasa_4, getString(R.string.lhasa_description_4)));
        mLS.add(new Tourism(getString(R.string.lhasa_5), getString(R.string.lhasa_L5),
                R.drawable.lhasa_5, getString(R.string.lhasa_description_5)));
        mLS.add(new Tourism(getString(R.string.lhasa_6), getString(R.string.lhasa_L6),
                R.drawable.lhasa_6, getString(R.string.lhasa_description_6), getString(R.string.lhasa_date_1)));
    }
}
