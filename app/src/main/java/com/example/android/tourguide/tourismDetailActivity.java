package com.example.android.tourguide;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import static android.nfc.NfcAdapter.EXTRA_ID;
import static android.view.View.GONE;

public class tourismDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "tourism";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        Tourism tourism = data.getParcelable(EXTRA_NAME);
        final String tourismName = tourism.getTourismName();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(tourismName);

        loadBackdrop(tourism.getResourceId());

        TextView textView1 = (TextView) findViewById(R.id.mLocation);
        TextView textView2 = (TextView) findViewById(R.id.mDate);
        TextView textView3 = (TextView) findViewById(R.id.mDescription);
        CardView cardView = (CardView) findViewById(R.id.date_container);

        textView1.setText(tourism.getLocation());
        if (tourism.getDate().equals("")) {
            cardView.setVisibility(View.GONE);
        } else {
            cardView.setVisibility(View.VISIBLE);
            textView2.setText(tourism.getDate());
        }
        textView3.setText(tourism.getDescription());
    }

    private void loadBackdrop(int id) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(id).centerCrop().into(imageView);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}

