/* Copyright (C) 2012 The Android Open Source Project
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
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import java.util.ArrayList;
import java.util.List;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.Map.OnMapLongClickListener;
import de.quist.app.mapsabstraction.Map.OnMarkerDragListener;
import de.quist.app.mapsabstraction.MapFragment;
import de.quist.app.mapsabstraction.OnMapReadyCallback;
import de.quist.app.mapsabstraction.model.BitmapDescriptorFactory;
import de.quist.app.mapsabstraction.model.Circle;
import de.quist.app.mapsabstraction.model.LatLng;
import de.quist.app.mapsabstraction.model.Marker;


/**
 * This shows how to draw circles on a map.
 */
public class CircleDemoActivity extends FragmentActivity implements OnSeekBarChangeListener,
        OnMarkerDragListener, OnMapLongClickListener, OnMapReadyCallback {
    private static final LatLng SYDNEY = BuildConfig.MAP_IMPLEMENTATION.latLng(-33.87365, 151.20689);
    private static final double DEFAULT_RADIUS = 1000000;
    public static final double RADIUS_OF_EARTH_METERS = 6371009;

    private static final int WIDTH_MAX = 50;
    private static final int HUE_MAX = 360;
    private static final int ALPHA_MAX = 255;

    private Map mMap;

    private List<DraggableCircle> mCircles = new ArrayList<DraggableCircle>(1);

    private SeekBar mColorBar;
    private SeekBar mAlphaBar;
    private SeekBar mWidthBar;
    private int mStrokeColor;
    private int mFillColor;

    private class DraggableCircle {
        private final Marker centerMarker;
        private final Marker radiusMarker;
        private final Circle circle;
        private double radius;
        public DraggableCircle(LatLng center, double radius) {
            this.radius = radius;
            centerMarker = mMap.addMarker(BuildConfig.MAP_IMPLEMENTATION.markerOptions()
                    .position(center)
                    .draggable(true));
            radiusMarker = mMap.addMarker(BuildConfig.MAP_IMPLEMENTATION.markerOptions()
                    .position(toRadiusLatLng(center, radius))
                    .draggable(true)
                    .icon(BuildConfig.MAP_IMPLEMENTATION.bitmapDescriptorFactory().defaultMarker(
                            BitmapDescriptorFactory.HUE_AZURE)));
            circle = mMap.addCircle(BuildConfig.MAP_IMPLEMENTATION.circleOptions()
                    .center(center)
                    .radius(radius)
                    .strokeWidth(mWidthBar.getProgress())
                    .strokeColor(mStrokeColor)
                    .fillColor(mFillColor));
        }
        public DraggableCircle(LatLng center, LatLng radiusLatLng) {
            this.radius = toRadiusMeters(center, radiusLatLng);
            centerMarker = mMap.addMarker(BuildConfig.MAP_IMPLEMENTATION.markerOptions()
                    .position(center)
                    .draggable(true));
            radiusMarker = mMap.addMarker(BuildConfig.MAP_IMPLEMENTATION.markerOptions()
                    .position(radiusLatLng)
                    .draggable(true)
                    .icon(BuildConfig.MAP_IMPLEMENTATION.bitmapDescriptorFactory().defaultMarker(
                            BitmapDescriptorFactory.HUE_AZURE)));
            circle = mMap.addCircle(BuildConfig.MAP_IMPLEMENTATION.circleOptions()
                    .center(center)
                    .radius(radius)
                    .strokeWidth(mWidthBar.getProgress())
                    .strokeColor(mStrokeColor)
                    .fillColor(mFillColor));
        }
        public boolean onMarkerMoved(Marker marker) {
            if (marker.equals(centerMarker)) {
                circle.setCenter(marker.getPosition());
                radiusMarker.setPosition(toRadiusLatLng(marker.getPosition(), radius));
                return true;
            }
            if (marker.equals(radiusMarker)) {
                 radius = toRadiusMeters(centerMarker.getPosition(), radiusMarker.getPosition());
                 circle.setRadius(radius);
                 return true;
            }
            return false;
        }
        public void onStyleChange() {
            circle.setStrokeWidth(mWidthBar.getProgress());
            circle.setFillColor(mFillColor);
            circle.setStrokeColor(mStrokeColor);
        }
    }

    /** Generate LatLng of radius marker */
    private static LatLng toRadiusLatLng(LatLng center, double radius) {
        double radiusAngle = Math.toDegrees(radius / RADIUS_OF_EARTH_METERS) /
                Math.cos(Math.toRadians(center.latitude()));
        return BuildConfig.MAP_IMPLEMENTATION.latLng(center.latitude(), center.longitude() + radiusAngle);
    }

    private static double toRadiusMeters(LatLng center, LatLng radius) {
        float[] result = new float[1];
        Location.distanceBetween(center.latitude(), center.longitude(),
                radius.latitude(), radius.longitude(), result);
        return result[0];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_demo);

        mColorBar = (SeekBar) findViewById(R.id.hueSeekBar);
        mColorBar.setMax(HUE_MAX);
        mColorBar.setProgress(0);

        mAlphaBar = (SeekBar) findViewById(R.id.alphaSeekBar);
        mAlphaBar.setMax(ALPHA_MAX);
        mAlphaBar.setProgress(127);

        mWidthBar = (SeekBar) findViewById(R.id.widthSeekBar);
        mWidthBar.setMax(WIDTH_MAX);
        mWidthBar.setProgress(10);

        MapFragment mapFragment = BuildConfig.MAP_IMPLEMENTATION.mapFragmentFrom(getSupportFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(Map map) {
        mMap = map;

        // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localised.
        map.setContentDescription("Google Map with circles.");

        mColorBar.setOnSeekBarChangeListener(this);
        mAlphaBar.setOnSeekBarChangeListener(this);
        mWidthBar.setOnSeekBarChangeListener(this);
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);

        mFillColor = Color.HSVToColor(
                mAlphaBar.getProgress(), new float[] {mColorBar.getProgress(), 1, 1});
        mStrokeColor = Color.BLACK;

        DraggableCircle circle = new DraggableCircle(SYDNEY, DEFAULT_RADIUS);
        mCircles.add(circle);

        // Move the map so that it is centered on the initial circle
        mMap.moveCamera(BuildConfig.MAP_IMPLEMENTATION.cameraUpdateFactory().newLatLngZoom(SYDNEY, 4.0f));
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
        if (seekBar == mColorBar) {
            mFillColor = Color.HSVToColor(Color.alpha(mFillColor), new float[] {progress, 1, 1});
        } else if (seekBar == mAlphaBar) {
            mFillColor = Color.argb(progress, Color.red(mFillColor), Color.green(mFillColor),
                  Color.blue(mFillColor));
        }

        for (DraggableCircle draggableCircle : mCircles) {
            draggableCircle.onStyleChange();
        }
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        onMarkerMoved(marker);
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        onMarkerMoved(marker);
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        onMarkerMoved(marker);
    }

    private void onMarkerMoved(Marker marker) {
        for (DraggableCircle draggableCircle : mCircles) {
            if (draggableCircle.onMarkerMoved(marker)) {
                break;
            }
        }
    }

    @Override
    public void onMapLongClick(LatLng point) {
        // We know the center, let's place the outline at a point 3/4 along the view.
        View view = (BuildConfig.MAP_IMPLEMENTATION.mapFragmentFrom(getSupportFragmentManager().findFragmentById(R.id.map)))
                .getView();
        LatLng radiusLatLng = mMap.getProjection().fromScreenLocation(new Point(
            view.getHeight() * 3 / 4, view.getWidth() * 3 / 4));

        // ok create it
        DraggableCircle circle = new DraggableCircle(point, radiusLatLng);
        mCircles.add(circle);
    }
}
