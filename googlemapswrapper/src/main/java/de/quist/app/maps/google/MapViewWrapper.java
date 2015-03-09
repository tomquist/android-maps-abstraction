package de.quist.app.maps.google;

import android.os.Bundle;
import android.view.View;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;

class MapViewWrapper implements de.quist.app.maps.MapViewWrapper {

    public static com.google.android.gms.maps.MapView unwrap(de.quist.app.maps.MapViewWrapper map) {
        return map != null ? ((de.quist.app.maps.google.MapViewWrapper)map).original : null;
    }

    public static de.quist.app.maps.google.MapViewWrapper wrap(com.google.android.gms.maps.MapView map) {
        return map != null ? new de.quist.app.maps.google.MapViewWrapper(map) : null;
    }

    private final com.google.android.gms.maps.MapView original;

    MapViewWrapper(com.google.android.gms.maps.MapView original) {
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
