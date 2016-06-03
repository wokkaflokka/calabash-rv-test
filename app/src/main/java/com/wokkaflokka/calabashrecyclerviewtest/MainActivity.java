package com.wokkaflokka.calabashrecyclerviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.wokkaflokka.calabashrecyclerviewtest.adapters.ConfigurationTogglingAdapter;
import com.wokkaflokka.calabashrecyclerviewtest.adapters.PhotosAdapter;
import com.wokkaflokka.calabashrecyclerviewtest.configuration.ArchivedPhotoConfiguration;
import com.wokkaflokka.calabashrecyclerviewtest.configuration.PublishedPhotoConfiguration;
import com.wokkaflokka.calabashrecyclerviewtest.dtos.Issue707Model;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Toolbar toolbar;
    private Spinner toolbarSpinner;
    private RecyclerView recyclerView;
    private PhotosAdapter photosAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private final Issue707Model model = Issue707Model.getTestModel();

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        photosAdapter = new PhotosAdapter(this, this, new PublishedPhotoConfiguration(model));
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(photosAdapter);
        animationAdapter.setFirstOnly(false);
        animationAdapter.setInterpolator(new OvershootInterpolator());

        recyclerView.setAdapter(animationAdapter);
        recyclerView.setLayoutManager(layoutManager);

        toolbarSpinner = (Spinner) findViewById(R.id.gallery_selector);
        toolbarSpinner.setAdapter(new ConfigurationTogglingAdapter(this, model));
        toolbarSpinner.setSelection(0, false);
        toolbarSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            photosAdapter.setConfiguration(new PublishedPhotoConfiguration(model));
        } else {
            photosAdapter.setConfiguration(new ArchivedPhotoConfiguration(model));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Intent intent = DummyActivity.getIntent(this);
        startActivity(intent);
    }
}
