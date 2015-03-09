/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.quist.app.mapsabstraction.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import java.util.Arrays;
import java.util.List;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.MapFragment;
import de.quist.app.mapsabstraction.OnMapReadyCallback;
import de.quist.app.mapsabstraction.model.LatLng;
import de.quist.app.mapsabstraction.model.Polygon;
import de.quist.app.mapsabstraction.model.PolygonOptions;

/**
 * This shows how to draw polygons on a map.
 */
public class PolygonDemoActivity extends FragmentActivity
        implements OnSeekBarChangeListener, OnMapReadyCallback {

    private static final LatLng SYDNEY = BuildConfig.MAP_IMPLEMENTATION.latLng(-33.87365, 151.20689);

    private static final int WIDTH_MAX = 50;
    private static final int HUE_MAX = 360;
    private static final int ALPHA_MAX = 255;

    private Polygon mMutablePolygon;

    private SeekBar mColorBar;
    private SeekBar mAlphaBar;
    private SeekBar mWidthBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.polygon_demo);

        mColorBar = (SeekBar) findViewById(R.id.hueSeekBar);
        mColorBar.setMax(HUE_MAX);
        mColorBar.setProgress(0);

        mAlphaBar = (SeekBar) findViewById(R.id.alphaSeekBar);
        mAlphaBar.setMax(ALPHA_MAX);
        mAlphaBar.setProgress(127);

        mWidthBar = (SeekBar) findViewById(R.id.widthSeekBar);
        mWidthBar.setMax(WIDTH_MAX);
        mWidthBar.setProgress(10);

        MapFragment mapFragment =
                BuildConfig.MAP_IMPLEMENTATION.mapFragmentFrom(getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(Map map) {
        // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localised.
        map.setContentDescription("Google Map with polygons.");

        // Create a rectangle with two rectangular holes.
        map.addPolygon(BuildConfig.MAP_IMPLEMENTATION.polygonOptions()
                .addAll(createRectangle(BuildConfig.MAP_IMPLEMENTATION.latLng(-20, 130), 5, 5))
                .addHole(createRectangle(BuildConfig.MAP_IMPLEMENTATION.latLng(-22, 128), 1, 1))
                .addHole(createRectangle(BuildConfig.MAP_IMPLEMENTATION.latLng(-18, 133), 0.5, 1.5))
                .fillColor(Color.CYAN)
                .strokeColor(Color.BLUE)
                .strokeWidth(5));

        // Create a rectangle centered at Sydney.
        PolygonOptions options = BuildConfig.MAP_IMPLEMENTATION.polygonOptions().addAll(createRectangle(SYDNEY, 5, 8));

        int fillColor = Color.HSVToColor(
                mAlphaBar.getProgress(), new float[] {mColorBar.getProgress(), 1, 1});
        mMutablePolygon = map.addPolygon(options
                .strokeWidth(mWidthBar.getProgress())
                .strokeColor(Color.BLACK)
                .fillColor(fillColor));

        mColorBar.setOnSeekBarChangeListener(this);
        mAlphaBar.setOnSeekBarChangeListener(this);
        mWidthBar.setOnSeekBarChangeListener(this);

        // Move the map so that it is centered on the mutable polygon.
        map.moveCamera(BuildConfig.MAP_IMPLEMENTATION.cameraUpdateFactory().newLatLng(SYDNEY));
    }

    /**
     * Creates a List of LatLngs that form a rectangle with the given dimensions.
     */
    private List<LatLng> createRectangle(LatLng center, double halfWidth, double halfHeight) {
        return Arrays.asList(BuildConfig.MAP_IMPLEMENTATION.latLng(center.latitude() - halfHeight, center.longitude() - halfWidth),
                BuildConfig.MAP_IMPLEMENTATION.latLng(center.latitude() - halfHeight, center.longitude() + halfWidth),
                BuildConfig.MAP_IMPLEMENTATION.latLng(center.latitude() + halfHeight, center.longitude() + halfWidth),
                BuildConfig.MAP_IMPLEMENTATION.latLng(center.latitude() + halfHeight, center.longitude() - halfWidth),
                BuildConfig.MAP_IMPLEMENTATION.latLng(center.latitude() - halfHeight, center.longitude() - halfWidth));
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Don't do anything here.
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Don't do anything here.
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (mMutablePolygon == null) {
            return;
        }

        if (seekBar == mColorBar) {
            mMutablePolygon.setFillColor(Color.HSVToColor(
                    Color.alpha(mMutablePolygon.getFillColor()), new float[] {progress, 1, 1}));
        } else if (seekBar == mAlphaBar) {
            int prevColor = mMutablePolygon.getFillColor();
            mMutablePolygon.setFillColor(Color.argb(
                    progress, Color.red(prevColor), Color.green(prevColor),
                    Color.blue(prevColor)));
        } else if (seekBar == mWidthBar) {
            mMutablePolygon.setStrokeWidth(progress);
        }
    }
}
