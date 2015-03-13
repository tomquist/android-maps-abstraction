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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import de.quist.app.maps.Map;
import de.quist.app.maps.MapFragmentWrapper;
import de.quist.app.maps.OnMapReadyCallback;

/**
 * Demonstrates how to instantiate a SupportMapFragment programmatically and add a marker to it.
 */
public class ProgrammaticDemoActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String MAP_FRAGMENT_TAG = "map";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // It isn't possible to set a fragment's id programmatically so we set a tag instead and
        // search for it using that.
        MapFragmentWrapper mapFragmentWrapper =
                BuildConfig.MAP_BINDING.mapFragmentWrapperFrom(getSupportFragmentManager().findFragmentByTag(MAP_FRAGMENT_TAG));

        // We only create a fragment if it doesn't already exist.
        if (mapFragmentWrapper == null) {
            // To programmatically add the map, we first create a SupportMapFragment.
            Fragment fragment = BuildConfig.MAP_BINDING.newSupportMapFragmentInstance();
            mapFragmentWrapper = BuildConfig.MAP_BINDING.mapFragmentWrapperFrom(fragment);

            // Then we add it using a FragmentTransaction.
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(android.R.id.content, fragment, MAP_FRAGMENT_TAG);
            fragmentTransaction.commit();

            mapFragmentWrapper.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(Map map) {
        map.addMarker(BuildConfig.MAP_BINDING.newMarkerOptions().position(BuildConfig.MAP_BINDING.newLatLng(0, 0)).title("Marker"));
    }
}
