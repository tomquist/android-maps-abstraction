package de.quist.app.mapsabstraction.googlemapswrapper;

import android.os.Bundle;
import android.view.View;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.OnMapReadyCallback;

class MapView implements de.quist.app.mapsabstraction.MapView {

    public static com.google.android.gms.maps.MapView unwrap(de.quist.app.mapsabstraction.MapView map) {
        return map != null ? ((MapView)map).original : null;
    }

    public static MapView wrap(com.google.android.gms.maps.MapView map) {
        return map != null ? new MapView(map) : null;
    }

    private final com.google.android.gms.maps.MapView original;

    MapView(com.google.android.gms.maps.MapView original) {
        this.original = original;
    }

    @Override
    public Map getMap() {
        return GoogleMap.wrap(original.getMap());
    }

    @Override
    public void getMapAsync(final OnMapReadyCallback callback) {
        com.google.android.gms.maps.OnMapReadyCallback wrapperCallback = null;
        if (callback != null) {
            wrapperCallback = new com.google.android.gms.maps.OnMapReadyCallback() {
                @Override
                public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
                    callback.onMapReady(GoogleMap.wrap(googleMap));
                }
            };
        }
        original.getMapAsync(wrapperCallback);
    }

    @Override
    public View getView() {
        return original;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        original.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        original.onResume();
    }

    @Override
    public void onPause() {
        original.onPause();
    }

    @Override
    public void onDestroy() {
        original.onDestroy();
    }

    @Override
    public void onLowMemory() {
        original.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        original.onSaveInstanceState(outState);
    }

}
