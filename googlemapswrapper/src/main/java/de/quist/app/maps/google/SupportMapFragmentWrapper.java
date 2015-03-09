package de.quist.app.maps.google;

import android.view.View;

import de.quist.app.maps.Map;
import de.quist.app.maps.MapFragmentWrapper;
import de.quist.app.maps.OnMapReadyCallback;

class SupportMapFragmentWrapper implements MapFragmentWrapper {

    public static com.google.android.gms.maps.SupportMapFragment unwrap(SupportMapFragmentWrapper map) {
        return map != null ? map.original : null;
    }

    public static SupportMapFragmentWrapper wrap(com.google.android.gms.maps.SupportMapFragment map) {
        return map != null ? new SupportMapFragmentWrapper(map) : null;
    }

    private final com.google.android.gms.maps.SupportMapFragment original;

    SupportMapFragmentWrapper(com.google.android.gms.maps.SupportMapFragment original) {
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
        return original.getView();
    }
}
