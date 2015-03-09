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

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.Map.OnCameraChangeListener;
import de.quist.app.mapsabstraction.Map.OnMapClickListener;
import de.quist.app.mapsabstraction.Map.OnMapLongClickListener;
import de.quist.app.mapsabstraction.MapFragment;
import de.quist.app.mapsabstraction.OnMapReadyCallback;
import de.quist.app.mapsabstraction.model.CameraPosition;
import de.quist.app.mapsabstraction.model.LatLng;

/**
 * This shows how to listen to some {@link Map} events.
 */
public class EventsDemoActivity extends FragmentActivity
        implements OnMapClickListener, OnMapLongClickListener, OnCameraChangeListener,
                OnMapReadyCallback {

    private TextView mTapTextView;
    private TextView mCameraTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_demo);

        mTapTextView = (TextView) findViewById(R.id.tap_text);
        mCameraTextView = (TextView) findViewById(R.id.camera_text);

        MapFragment mapFragment =
                BuildConfig.MAP_IMPLEMENTATION.mapFragmentFrom(getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(Map map) {
        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);
        map.setOnCameraChangeListener(this);
    }

    @Override
    public void onMapClick(LatLng point) {
        mTapTextView.setText("tapped, point=" + point);
    }

    @Override
    public void onMapLongClick(LatLng point) {
        mTapTextView.setText("long pressed, point=" + point);
    }

    @Override
    public void onCameraChange(final CameraPosition position) {
        mCameraTextView.setText(position.toString());
    }
}
