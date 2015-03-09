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

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.MapFragment;
import de.quist.app.mapsabstraction.OnMapReadyCallback;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class BasicMapDemoActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_demo);

        MapFragment mapFragment = BuildConfig.MAP_IMPLEMENTATION.mapFragmentFrom(getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     */
    @Override
    public void onMapReady(Map map) {
        map.addMarker(BuildConfig.MAP_IMPLEMENTATION.markerOptions().position(BuildConfig.MAP_IMPLEMENTATION.latLng(0, 0)).title("Marker"));
    }
}
