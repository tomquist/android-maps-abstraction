package de.quist.app.mapsabstraction.googlemapswrapper;

import android.view.View;

import de.quist.app.mapsabstraction.Map;
import de.quist.app.mapsabstraction.OnMapReadyCallback;

class MapFragment implements de.quist.app.mapsabstraction.MapFragment {

    public static com.google.android.gms.maps.MapFragment unwrap(MapFragment map) {
        return map != null ? map.original : null;
    }

    public static MapFragment wrap(com.google.android.gms.maps.MapFragment map) {
        return map != null ? new MapFragment(map) : null;
    }

    private final com.google.android.gms.maps.MapFragment original;

    MapFragment(com.google.android.gms.maps.MapFragment original) {
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
