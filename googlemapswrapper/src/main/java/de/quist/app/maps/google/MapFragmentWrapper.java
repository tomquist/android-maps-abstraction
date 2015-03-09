package de.quist.app.maps.google;

import android.view.View;

import de.quist.app.maps.Map;
import de.quist.app.maps.OnMapReadyCallback;

class MapFragmentWrapper implements de.quist.app.maps.MapFragmentWrapper {

    public static com.google.android.gms.maps.MapFragment unwrap(de.quist.app.maps.google.MapFragmentWrapper map) {
        return map != null ? map.original : null;
    }

    public static de.quist.app.maps.google.MapFragmentWrapper wrap(com.google.android.gms.maps.MapFragment map) {
        return map != null ? new de.quist.app.maps.google.MapFragmentWrapper(map) : null;
    }

    private final com.google.android.gms.maps.MapFragment original;

    MapFragmentWrapper(com.google.android.gms.maps.MapFragment original) {
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
