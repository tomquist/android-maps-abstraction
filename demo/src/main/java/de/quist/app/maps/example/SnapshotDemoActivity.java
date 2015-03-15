// Copyright 2013 Google Inc. All Rights Reserved.

package de.quist.app.maps.example;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import de.quist.app.maps.Map;
import de.quist.app.maps.Map.OnMapLoadedCallback;
import de.quist.app.maps.Map.SnapshotReadyCallback;
import de.quist.app.maps.OnMapReadyCallback;
import de.quist.app.maps.SupportMapFragment;

/**
 * This shows how to take a snapshot of the map.
 */
public class SnapshotDemoActivity extends FragmentActivity implements OnMapReadyCallback {

    /**
     * Note that this may be null if the Google Play services APK is not available.
     */
    private Map mMap;

    private CheckBox mWaitForMapLoadCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snapshot_demo);
        mWaitForMapLoadCheckBox = (CheckBox) findViewById(R.id.wait_for_map_load);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(Map map) {
        mMap = map;
    }

    /**
     * Called when the snapshot button is clicked.
     */
    public void onScreenshot(View view) {
        takeSnapshot();
    }

    private void takeSnapshot() {
        if (mMap == null) {
            return;
        }

        final ImageView snapshotHolder = (ImageView) findViewById(R.id.snapshot_holder);

        final SnapshotReadyCallback callback = new SnapshotReadyCallback() {
            @Override
            public void onSnapshotReady(Bitmap snapshot) {
                // Callback is called from the main thread, so we can modify the ImageView safely.
                snapshotHolder.setImageBitmap(snapshot);
            }
        };

        if (mWaitForMapLoadCheckBox.isChecked()) {
            mMap.setOnMapLoadedCallback(new OnMapLoadedCallback() {
                @Override
                public void onMapLoaded() {
                    mMap.snapshot(callback);
                }
            });
        } else {
            mMap.snapshot(callback);
        }
    }

    /**
     * Called when the clear button is clicked.
     */
    public void onClearScreenshot(View view) {
        ImageView snapshotHolder = (ImageView) findViewById(R.id.snapshot_holder);
        snapshotHolder.setImageDrawable(null);
    }
}
