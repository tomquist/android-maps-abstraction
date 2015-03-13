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

package de.quist.app.maps.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import de.quist.app.maps.Map;
import de.quist.app.maps.MapFragmentWrapper;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.model.LatLng;
import de.quist.app.maps.model.Polyline;
import de.quist.app.maps.model.PolylineOptions;

/**
 * This shows how to draw polylines on a map.
 */
public class PolylineDemoActivity extends FragmentActivity
        implements OnSeekBarChangeListener, OnMapReadyCallback {

    private static final LatLng MELBOURNE = BuildConfig.MAP_BINDING.newLatLng(-37.81319, 144.96298);
    private static final LatLng SYDNEY = BuildConfig.MAP_BINDING.newLatLng(-33.87365, 151.20689);
    private static final LatLng ADELAIDE = BuildConfig.MAP_BINDING.newLatLng(-34.92873, 138.59995);
    private static final LatLng PERTH = BuildConfig.MAP_BINDING.newLatLng(-31.95285, 115.85734);

    private static final LatLng LHR = BuildConfig.MAP_BINDING.newLatLng(51.471547, -0.460052);
    private static final LatLng LAX = BuildConfig.MAP_BINDING.newLatLng(33.936524, -118.377686);
    private static final LatLng JFK = BuildConfig.MAP_BINDING.newLatLng(40.641051, -73.777485);
    private static final LatLng AKL = BuildConfig.MAP_BINDING.newLatLng(-37.006254, 174.783018);

    private static final int WIDTH_MAX = 50;
    private static final int HUE_MAX = 360;
    private static final int ALPHA_MAX = 255;

    private Polyline mMutablePolyline;
    private SeekBar mColorBar;
    private SeekBar mAlphaBar;
    private SeekBar mWidthBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.polyline_demo);

        mColorBar = (SeekBar) findViewById(R.id.hueSeekBar);
        mColorBar.setMax(HUE_MAX);
        mColorBar.setProgress(0);

        mAlphaBar = (SeekBar) findViewById(R.id.alphaSeekBar);
        mAlphaBar.setMax(ALPHA_MAX);
        mAlphaBar.setProgress(255);

        mWidthBar = (SeekBar) findViewById(R.id.widthSeekBar);
        mWidthBar.setMax(WIDTH_MAX);
        mWidthBar.setProgress(10);

        MapFragmentWrapper mapFragmentWrapper =
                BuildConfig.MAP_BINDING.mapFragmentWrapperFrom(getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragmentWrapper.getMapAsync(this);
    }

    @Override
    public void onMapReady(Map map) {
        // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localised.
        map.setContentDescription("Google Map with polylines.");

        // A simple polyline with the default options from Melbourne-Adelaide-Perth.
        map.addPolyline((BuildConfig.MAP_BINDING.newPolylineOptions())
                .add(MELBOURNE, ADELAIDE, PERTH));

        // A geodesic polyline that goes around the world.
        map.addPolyline((BuildConfig.MAP_BINDING.newPolylineOptions())
                .add(LHR, AKL, LAX, JFK, LHR)
                .width(5)
                .color(Color.BLUE)
                .geodesic(true));

        // Rectangle centered at Sydney.  This polyline will be mutable.
        int radius = 5;
        PolylineOptions options = BuildConfig.MAP_BINDING.newPolylineOptions()
                .add(BuildConfig.MAP_BINDING.newLatLng(SYDNEY.latitude() + radius, SYDNEY.longitude() + radius))
                .add(BuildConfig.MAP_BINDING.newLatLng(SYDNEY.latitude() + radius, SYDNEY.longitude() - radius))
                .add(BuildConfig.MAP_BINDING.newLatLng(SYDNEY.latitude() - radius, SYDNEY.longitude() - radius))
                .add(BuildConfig.MAP_BINDING.newLatLng(SYDNEY.latitude() - radius, SYDNEY.longitude() + radius))
                .add(BuildConfig.MAP_BINDING.newLatLng(SYDNEY.latitude() + radius, SYDNEY.longitude() + radius));
        int color = Color.HSVToColor(
                mAlphaBar.getProgress(), new float[] {mColorBar.getProgress(), 1, 1});
        mMutablePolyline = map.addPolyline(options
                .color(color)
                .width(mWidthBar.getProgress()));

        mColorBar.setOnSeekBarChangeListener(this);
        mAlphaBar.setOnSeekBarChangeListener(this);
        mWidthBar.setOnSeekBarChangeListener(this);

        // Move the map so that it is centered on the mutable polyline.
        map.moveCamera(BuildConfig.MAP_BINDING.cameraUpdateFactory().newLatLng(SYDNEY));
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
        if (mMutablePolyline == null) {
            return;
        }

        if (seekBar == mColorBar) {
            mMutablePolyline.setColor(Color.HSVToColor(
                    Color.alpha(mMutablePolyline.getColor()), new float[] {progress, 1, 1}));
        } else if (seekBar == mAlphaBar) {
            float[] prevHSV = new float[3];
            Color.colorToHSV(mMutablePolyline.getColor(), prevHSV);
            mMutablePolyline.setColor(Color.HSVToColor(progress, prevHSV));
        } else if (seekBar == mWidthBar) {
            mMutablePolyline.setWidth(progress);
        }
    }
}
